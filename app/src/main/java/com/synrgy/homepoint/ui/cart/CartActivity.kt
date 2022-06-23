package com.synrgy.homepoint.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.synrgy.homepoint.databinding.ActivityCartBinding
import com.synrgy.homepoint.databinding.ActivityLoginBinding

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}