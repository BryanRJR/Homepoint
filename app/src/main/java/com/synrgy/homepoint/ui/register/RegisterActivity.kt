package com.synrgy.homepoint.ui.register

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface.BOLD
import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import android.net.LinkAddress
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.synrgy.homepoint.R
import com.synrgy.homepoint.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val foregroundSpan = getString(R.string.act_register_text_term_condition)

        val foregroundSpannableString = SpannableString(foregroundSpan)
        foregroundSpannableString.setSpan(
            StyleSpan(BOLD),
            34,
            52,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        foregroundSpannableString.setSpan(
            StyleSpan(BOLD),
            59,
            77,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        val foregroundSpannableStringTwo = SpannableString(foregroundSpan)
        foregroundSpannableStringTwo.setSpan(
            ForegroundColorSpan(getColor(R.color.txt_blue)),
            34,
            52,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        foregroundSpannableStringTwo.setSpan(
            ForegroundColorSpan(getColor(R.color.txt_blue)),
            59,
            77,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvTermCond.text = foregroundSpannableString
        binding.tvTermCond.text = foregroundSpannableStringTwo

    }

}