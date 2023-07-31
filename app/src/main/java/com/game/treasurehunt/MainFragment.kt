package com.game.treasurehunt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.game.treasurehunt.databinding.FragmentMainBinding
import com.game.treasurehunt.inquiry.InquiryFragment
import com.game.treasurehunt.treasureDescription.TreasureDescriptionFragment
import com.game.treasurehunt.treasureList.TreasureListFragment

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        binding.fabMainMoveListFragment.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_main, TreasureListFragment())
                commit()
            }
        }

        binding.fabMainMoveRegistration.setOnClickListener {
            val bundle = Bundle().apply {
                putString("treasure", "남대문")
            }

            val inquiryFragment = InquiryFragment()
            inquiryFragment.arguments = bundle
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_main, inquiryFragment)
                commit()
            }
        }
    }


}