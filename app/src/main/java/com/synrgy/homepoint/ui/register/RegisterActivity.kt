package com.synrgy.homepoint.ui.register

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.synrgy.homepoint.R
import com.synrgy.homepoint.data.remote.response.UserResponse
import com.synrgy.homepoint.data.remote.retrofit.ApiServices
import com.synrgy.homepoint.data.remote.retrofit.RegisterRequest
import com.synrgy.homepoint.data.remote.retrofit.Retrofit
import com.synrgy.homepoint.databinding.ActivityRegisterBinding
import com.synrgy.homepoint.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var email: EditText
    private lateinit var name: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = findViewById(R.id.et_email)
        name = findViewById(R.id.et_name)
        password = findViewById(R.id.et_password)

        binding.btnDaftar.setOnClickListener {
            register()
        }

        binding.tvBtnToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.tvTermCond.makeLinks(
            Pair("Syarat & Ketentuan", View.OnClickListener {
                Toast.makeText(this, "Menu Belum Tersedia", Toast.LENGTH_SHORT).show()
            }),
            Pair("Kebijakan Privasi", View.OnClickListener {
                Toast.makeText(this, "Menu Belum Tersedia", Toast.LENGTH_SHORT).show()
            })
        )
    }

    private fun TextView.makeLinks(vararg links: Pair<String, View.OnClickListener>) {
        val linkText = this.text
        val spannableString = SpannableString(linkText)

        for (link in links) {
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    Selection.setSelection((widget as TextView).text as Spannable, 0)
                    widget.invalidate()
                    link.second.onClick(widget)
                }
                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = false
                    ds.color = Color.parseColor("#316093")
                    ds.typeface = Typeface.DEFAULT_BOLD
                }
            }

            val startIndexOfLink = this.text.toString().indexOf(link.first)
            spannableString.setSpan(
                clickableSpan,
                startIndexOfLink,
                startIndexOfLink + link.first.length,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
            )

        }

        this.movementMethod = LinkMovementMethod.getInstance()
        this.setText(spannableString, TextView.BufferType.SPANNABLE)
    }

    private fun register() {
        val userRegister = RegisterRequest()
        userRegister.email = email.text.toString().trim()
        userRegister.name = name.text.toString().trim()
        userRegister.password = password.text.toString().trim()

        val retroRegis = Retrofit().getRetroClientInstance().create(ApiServices::class.java)
        retroRegis.register(userRegister).enqueue(object : retrofit2.Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {

                if (userRegister.email!!.isEmpty()) {
                    email.error = "email is required!"
                    email.requestFocus()
                } else if(userRegister.name!!.isEmpty()) {
                    name.error = "name is required!"
                    name.requestFocus()
                } else if (userRegister.password!!.isEmpty()) {
                    password.error = "password is required!"
                    password.requestFocus()

                }
//                else if (userRegister.c_password!!.isEmpty()) {
//                    c_password.error = "confirm password is required!"
//                    c_password.requestFocus()
//                }
                else if(response.isSuccessful){
                    val regis = response.body()
                    Log.d("name", regis!!.data?.name.toString())
                    Log.d("token", regis!!.data?.token.toString())
                    Toast.makeText(this@RegisterActivity, "successfully registered!", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@RegisterActivity, "failed to register!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "please, try again!", Toast.LENGTH_SHORT).show()
            }

        })
    }

}