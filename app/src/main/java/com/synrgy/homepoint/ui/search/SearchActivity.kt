package com.synrgy.homepoint.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.synrgy.homepoint.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}