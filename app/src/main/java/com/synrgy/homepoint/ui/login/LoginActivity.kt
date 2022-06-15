package com.synrgy.homepoint.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.synrgy.homepoint.R
import com.synrgy.homepoint.data.remote.response.UserResponse
import com.synrgy.homepoint.data.remote.retrofit.ApiServices
import com.synrgy.homepoint.data.remote.retrofit.UserRequest
import com.synrgy.homepoint.data.remote.retrofit.Retrofit
import com.synrgy.homepoint.databinding.ActivityLoginBinding
import com.synrgy.homepoint.ui.MainActivity
import com.synrgy.homepoint.ui.register.RegisterActivity
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = findViewById(R.id.et_email_login)
        password = findViewById(R.id.et_password_login)

        binding.btnLogin.setOnClickListener {
            login()
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

    private fun login() {
        val request = UserRequest()
        request.email = email.text.toString().trim()
        request.password = password.text.toString().trim()

        val retro = Retrofit().getRetroClientInstance().create(ApiServices::class.java)
        retro.login(request).enqueue(object : retrofit2.Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {

                // validasi untuk setiap field
                if(request.email!!.isEmpty()){
                    email.error = "email is required!"
                    email.requestFocus()
                }else if(request.password!!.isEmpty()){
                    password.error = "password is required!"
                    password.requestFocus()
                }else if(response.isSuccessful){
                    val user = response.body()
                    // melihat data lewat logcat
                    Log.d("name", user!!.data?.name.toString())
                    Log.d("token", user!!.data?.token.toString())
                    // jika berhasil login maka ada pesan login berhasil, dan otomatis pindah activity
                    Toast.makeText(this@LoginActivity, "login successfull!", Toast.LENGTH_SHORT).show()
                    intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    // pesan jika ada kesalahan login
                    Toast.makeText(this@LoginActivity, "login failed!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "please, try again!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}