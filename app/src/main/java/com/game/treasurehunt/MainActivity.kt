package com.game.treasurehunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.game.treasurehunt.databinding.ActivityMainBinding

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

    fun changeFragment(index: Int) {
        when (index) {
            MOVE_MAIN_FRAGMENT -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayout, MainFragment())
                    commit()
                }
            }
            MOVE_TREASURE_LIST_FRAGMENT -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayout, TreasureListFragment())
                    commit()
                }
            }
        }
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.fragments[0]
        if(currentFragment is MainFragment) {
            finish()
        } else if(currentFragment is TreasureListFragment) {
            changeFragment(MOVE_MAIN_FRAGMENT)
        }
    }
}