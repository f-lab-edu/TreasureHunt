package com.game.treasurehunt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.game.treasurehunt.databinding.FragmentTreasureListBinding

class TreasureListFragment : Fragment(){
    private lateinit var binding: FragmentTreasureListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTreasureListBinding.inflate(inflater)
        return binding.root
    }
}