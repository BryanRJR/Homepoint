package com.synrgy.homepoint.ui.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.synrgy.homepoint.databinding.ActivityConfirmPaymentBinding
import com.synrgy.homepoint.databinding.ActivityPaymentBinding

class ConfirmPaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}