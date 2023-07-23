package com.game.treasurehunt.treasureList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.game.treasurehunt.data.Treasure
import com.game.treasurehunt.databinding.ItemTreasureListBinding

class TreasureListAdapter(
    private val onClick: (Treasure) -> Unit
) : ListAdapter<Treasure, TreasureListAdapter.TreasureListViewHolder>(TreasureDiffCallback) {

    class TreasureListViewHolder(
        private val binding: ItemTreasureListBinding,
        val onClick: (Treasure) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var currentTreasure: Treasure ?= null

        init {
            binding.itemTreasureList.setOnClickListener {
                currentTreasure?.let {
                    onClick(it)
                }
            }
        }

        fun bind(treasure: Treasure) {
            currentTreasure = treasure

            binding.apply {
                textviewItemTreasureName.text = treasure.name
                textviewItemTreasureSearchTime.text = treasure.searchTime
                textviewItemTreasureIsLike.text = if (treasure.like) "좋아요" else ""
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreasureListViewHolder {
        val binding = ItemTreasureListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TreasureListViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: TreasureListViewHolder, position: Int) {
        val treasure = getItem(position)
        holder.bind(treasure)
    }
}

object TreasureDiffCallback : DiffUtil.ItemCallback<Treasure>() {
    override fun areItemsTheSame(oldItem: Treasure, newItem: Treasure): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Treasure, newItem: Treasure): Boolean {
        return oldItem.name == newItem.name
    }
}