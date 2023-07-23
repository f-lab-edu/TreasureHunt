package com.game.treasurehunt.treasureList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.game.treasurehunt.data.Treasure
import com.game.treasurehunt.databinding.FragmentTreasureListBinding

class TreasureListFragment : Fragment() {
    private lateinit var binding: FragmentTreasureListBinding
    private val treasureListViewModel by viewModels<TreasureListViewModel> {
        TreasureListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTreasureListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val treasureListHeaderAdapter = TreasureListHeaderAdapter()
        val treasureListAdapter = TreasureListAdapter { treasure -> adapterOnClick(treasure) }
        val concatAdapter = ConcatAdapter(treasureListHeaderAdapter, treasureListAdapter)

        binding.recyclerviewTreasureList.apply {
            adapter = concatAdapter
        }

        treasureListViewModel.treasureLiveData.observe(this) {
            it?.let {
                treasureListAdapter.submitList(it as MutableList<Treasure>)
                treasureListHeaderAdapter.updateTreasureCount(it.size)
            }
        }
    }

    private fun adapterOnClick(treasure: Treasure) {
        // TODO 코드 넣고 삭제
        Log.d("TreasureListFragment", "adapterOnClick : " + treasure.name)
    }
}