package com.game.treasurehunt

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.game.treasurehunt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(1)
    }

    fun changeFragment(index: Int) {
        when (index) {
            1 -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayout, MainFragment())
                    commit()
                }
            }
            2 -> {
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
            changeFragment(1)
        }
    }
}