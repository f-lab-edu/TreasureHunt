package com.game.treasurehunt.treasureDescription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.game.treasurehunt.R
import com.game.treasurehunt.databinding.FragmentTreasureDescriptionBinding
import com.game.treasurehunt.treasureList.TreasureListFragment

class TreasureDescriptionFragment : Fragment() {
    private lateinit var binding: FragmentTreasureDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTreasureDescriptionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        val image = arguments?.getInt("image") ?: 0
        val name = arguments?.getString("name") ?: ""
        val searchTime = arguments?.getString("searchTime") ?: ""
        val like = arguments?.getBoolean("like") ?: false

        binding.textviewTreasureDescriptionName.text = name
        binding.textviewTreasureDescriptionSearchTime.text = searchTime
        if (like)
            binding.textviewTreasureDescriptionIsLike.text = "좋아요"
        binding.textviewTreasureDescriptionLevel.text = "난이도 : 아직 설정 안됨"

        binding.textviewTreasureDescriptionDescription.text = "이 보물은 … (설명)"
        binding.textviewTreasureDescriptionMemo.text = "메모 : "

        binding.buttonTreasureDescriptionButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_main, TreasureListFragment())
                commit()
            }
        }
    }
}