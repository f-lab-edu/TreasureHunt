package com.game.treasurehunt.treasureList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.game.treasurehunt.R
import com.game.treasurehunt.data.Treasure
import com.game.treasurehunt.databinding.FragmentTreasureListBinding
import com.game.treasurehunt.treasureDescription.TreasureDescriptionFragment

class TreasureListFragment : Fragment() {
    private lateinit var binding: FragmentTreasureListBinding
    private val treasureListViewModel by viewModels<TreasureListViewModel> {
        TreasureListViewModelFactory()
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

        treasureListViewModel.treasureLiveData.observe(this) { list ->
            list?.let {
                treasureListAdapter.submitList(it as MutableList<Treasure>)
                treasureListHeaderAdapter.updateTreasureCount(it.size)
            }
        }
    }

    private fun adapterOnClick(treasure: Treasure) {
        val bundle = Bundle()
        bundle.putInt("image", treasure.image)
        bundle.putString("name", treasure.name)
        bundle.putString("searchTime", treasure.searchTime)
        bundle.putBoolean("like", treasure.like)
        bundle.putString("level", treasure.level)
        bundle.putString("description", treasure.description)
        bundle.putString("memo", treasure.memo)

        val treasureDescriptionFragment = TreasureDescriptionFragment()
        treasureDescriptionFragment.arguments = bundle
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout_main, treasureDescriptionFragment)
            commit()
        }
    }
}