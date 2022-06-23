package com.synrgy.homepoint.ui.profile.address

import android.os.Bundle
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.synrgy.homepoint.R
import com.synrgy.homepoint.databinding.ActivityAddAddressBinding
import com.synrgy.homepoint.ui.profile.DropdownAdapter

class AddAddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf("Material", "Design", "Components", "Android")
        val adapter = DropdownAdapter(this, R.layout.item_dropdown, items)
        (binding.tilProvince.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        (binding.tilCityRegency.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        (binding.tilDistrict.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        (binding.tilPostalCode.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        (binding.tilSubDistrict.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }
}