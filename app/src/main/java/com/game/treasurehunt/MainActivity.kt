package com.game.treasurehunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.game.treasurehunt.data.TreasureRepository
import com.game.treasurehunt.data.local.TreasureDatabase
import com.game.treasurehunt.data.treasureList
import com.game.treasurehunt.databinding.ActivityMainBinding
import com.game.treasurehunt.inquiry.InquiryFragment
import com.game.treasurehunt.registration.RegistrationFragment
import com.game.treasurehunt.treasureDescription.TreasureDescriptionFragment
import com.game.treasurehunt.treasureList.TreasureListFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val MOVE_MAIN_FRAGMENT = 1
        const val MOVE_TREASURE_LIST_FRAGMENT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(MOVE_MAIN_FRAGMENT)

        // TODO 삭제 (테스트 데이터 Room DB에 삽입)
        CoroutineScope(Dispatchers.IO).launch {
            for(i: Int in 0 until treasureList().size) {
                TreasureRepository(TreasureDatabase.getInstance(this@MainActivity)!!.treasureDao()).insert(treasureList()[i])
            }
        }
    }

    private fun changeFragment(index: Int) {
        when (index) {
            MOVE_MAIN_FRAGMENT -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_layout_main, MainFragment())
                    commit()
                }
            }
            MOVE_TREASURE_LIST_FRAGMENT -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_layout_main, TreasureListFragment())
                    commit()
                }
            }
        }
    }

    override fun onBackPressed() {
        when (supportFragmentManager.fragments[0]) {
            is MainFragment -> {
                finish()
            }
            is TreasureListFragment -> {
                changeFragment(MOVE_MAIN_FRAGMENT)
            }
            is TreasureDescriptionFragment -> {
                changeFragment(MOVE_TREASURE_LIST_FRAGMENT)
            }
            is InquiryFragment -> {
                changeFragment(MOVE_MAIN_FRAGMENT)
            }
            is RegistrationFragment -> {
                changeFragment(MOVE_MAIN_FRAGMENT)
            }
        }
    }
}