package com.synrgy.homepoint.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.synrgy.homepoint.R
import com.synrgy.homepoint.databinding.ActivityMainBinding
import com.synrgy.homepoint.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bnvMain.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_main_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                else -> false
            }
        }
    }

    // replace fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_main, fragment)
            .commit()
    }

    // stop fragment
    private fun stopFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .remove(fragment)
            .commit()
    }
}