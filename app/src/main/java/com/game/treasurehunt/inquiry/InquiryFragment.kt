package com.game.treasurehunt.inquiry

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.game.treasurehunt.MainFragment
import com.game.treasurehunt.R
import com.game.treasurehunt.databinding.FragmentInquiryBinding
import com.game.treasurehunt.registration.RegistrationFragment

class InquiryFragment : Fragment() {
    private lateinit var binding: FragmentInquiryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInquiryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    @SuppressLint("StringFormatMatches")
    private fun initView() {
        val treasure = arguments?.getString("treasure") ?: "보물"
        binding.textviewInquiryLine2.text = getString(R.string.textview_inquiry_line2, treasure)

        binding.buttonInquiryYes.setOnClickListener {
            val bundle = Bundle().apply {
                putString("treasure", treasure)
            }

            val registrationFragment = RegistrationFragment()
            registrationFragment.arguments = bundle
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_main, registrationFragment)
                commit()
            }
        }
        binding.buttonInquiryNo.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_main, MainFragment())
                commit()
            }
        }
    }
}