package com.synrgy.homepoint.ui.order

import android.graphics.Typeface
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.synrgy.homepoint.R
import com.synrgy.homepoint.databinding.ActivityRiwayatPesanBinding


class RiwayatPesanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRiwayatPesanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRiwayatPesanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in 0 until binding.tlRiwayatPesan.tabCount) {
            val tab: TabLayout.Tab? = binding.tlRiwayatPesan.getTabAt(i)
            if (tab != null) {
                val tabTextView = TextView(this)
                tab.customView = tabTextView
                tabTextView.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
                tabTextView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                tabTextView.text = tab.text

                if (i == 0) {
                    tabTextView.setTypeface(null, Typeface.BOLD)
                }
            }
        }

        binding.tlRiwayatPesan.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val text = tab!!.customView as TextView?

                text?.setTextAppearance(R.style.Widget_HomePoint_TabItem_Selected)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val text = tab!!.customView as TextView?

                text?.setTextAppearance(R.style.Widget_HomePoint_TabItem)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}