package com.synrgy.homepoint.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.synrgy.homepoint.databinding.ActivityLoginBinding
import com.synrgy.homepoint.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {

        }

        binding.btnForgetPassword.setOnClickListener {
            val intent = Intent(this, ForgetPassActivity::class.java)
            startActivity(intent)
        }

        binding.actLoginBtnDaftar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}