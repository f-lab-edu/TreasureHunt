package com.game.treasurehunt.treasureList

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.game.treasurehunt.databinding.ItemTreasureListHeaderBinding

class TreasureListHeaderAdapter :
    RecyclerView.Adapter<TreasureListHeaderAdapter.HeaderViewHolder>() {
    private var treasureCount: Int = 0

    class HeaderViewHolder(private val binding: ItemTreasureListHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(treasureCount: Int) {
            binding.apply {
                textviewItemTreasureListHeaderCount.text = treasureCount.toString()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemTreasureListHeaderBinding.inflate(inflater, parent, false)
        return HeaderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(treasureCount)
    }

    override fun getItemCount(): Int {
        return 1
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateTreasureCount(updatedTreasureCount: Int) {
        treasureCount = updatedTreasureCount
        notifyDataSetChanged()
    }
}