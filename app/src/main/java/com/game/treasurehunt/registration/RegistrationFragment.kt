package com.game.treasurehunt.registration

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.game.treasurehunt.MainFragment
import com.game.treasurehunt.R
import com.game.treasurehunt.databinding.FragmentRegistrationBinding
import java.text.SimpleDateFormat

class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    @SuppressLint("SimpleDateFormat")
    private fun initView() {
        val treasure = arguments?.getString("treasure") ?: "보물"
        val curTime: Long = System.currentTimeMillis()

        val dataFormat = SimpleDateFormat("yyyy-mm-dd hh:mm:ss")
        val searchTime = (dataFormat.format(curTime))

        binding.textviewRegistrationName.text = treasure
        binding.textviewRegistrationSearchTime.text = searchTime

        binding.buttonRegistrationRegistration.setOnClickListener {
            Toast.makeText(context, "등록이 완료 되었습니다.", Toast.LENGTH_SHORT).show()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_main, MainFragment())
                commit()
            }
        }

        binding.buttonRegistrationCancel.setOnClickListener {
            Toast.makeText(context, "취소 했습니다", Toast.LENGTH_SHORT).show()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_main, MainFragment())
                commit()
            }
        }
    }
}