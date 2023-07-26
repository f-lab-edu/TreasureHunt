package com.game.treasurehunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.game.treasurehunt.databinding.ActivityMainBinding
import com.game.treasurehunt.treasureDescription.TreasureDescriptionFragment
import com.game.treasurehunt.treasureList.TreasureListFragment

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
        }
    }
}