package com.synrgy.homepoint.ui.register

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.synrgy.homepoint.databinding.ActivityRegisterBinding
import com.synrgy.homepoint.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDaftar.setOnClickListener {
            Toast.makeText(this, "Menu Belum Tersedia", Toast.LENGTH_SHORT).show()
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

}