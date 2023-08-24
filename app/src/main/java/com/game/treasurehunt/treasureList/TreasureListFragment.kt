package com.game.treasurehunt.treasureList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.game.treasurehunt.MainFragment
import com.game.treasurehunt.R
import com.game.treasurehunt.data.Treasure
import com.game.treasurehunt.data.TreasureRepository
import com.game.treasurehunt.data.local.TreasureDatabase
import com.game.treasurehunt.databinding.FragmentTreasureListBinding
import com.game.treasurehunt.treasureDescription.TreasureDescriptionFragment

class TreasureListFragment : Fragment() {
    private lateinit var binding: FragmentTreasureListBinding
    private val treasureListViewModel by viewModels<TreasureListViewModel> {
        TreasureListViewModelFactory(
            TreasureRepository(
                TreasureDatabase.getInstance(requireContext())!!.treasureDao()
            )
        )
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
        initToolBar()
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
        val bundle = Bundle().apply {
            putString("image", treasure.image)
            putString("name", treasure.name)
            putString("searchTime", treasure.searchTime)
            putBoolean("like", treasure.like)
            putSerializable("level", treasure.level)
            putString("description", treasure.description)
            putString("memo", treasure.memo)
        }

        val treasureDescriptionFragment = TreasureDescriptionFragment()
        treasureDescriptionFragment.arguments = bundle
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout_main, treasureDescriptionFragment)
            commit()
        }
    }

    private fun initToolBar() {
        binding.toolbarImageviewTreasureListBack.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_main, MainFragment())
                commit()
            }
        }
    }
}