package com.game.treasurehunt.treasureList

import android.content.Context
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
            binding.treasureList.setOnClickListener {
                currentTreasure?.let {
                    onClick(it)
                }
            }
        }

        fun bind(treasure: Treasure) {
            currentTreasure = treasure

            binding.apply {
                nameView.text = treasure.name
                timeView.text = treasure.searchTime
                likeView.text = if (treasure.like) "좋아요" else ""
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreasureListViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemTreasureListBinding.inflate(inflater, parent, false)
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