package com.synrgy.homepoint.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.synrgy.homepoint.R
import com.synrgy.homepoint.data.local.model.OfferProduct
import com.synrgy.homepoint.databinding.ActivityProductDetailBinding
import com.synrgy.homepoint.ui.home.DataSource
import com.synrgy.homepoint.ui.home.OfferAdapter

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var offerAdapter: OfferAdapter
    private var listOfferProduct: ArrayList<OfferProduct> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerViewOffer()
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setupRecyclerViewOffer() {
        listOfferProduct.addAll(DataSource.listOfferProduct)
        offerAdapter = OfferAdapter(listOfferProduct)
        binding.rvOtherProduct.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = offerAdapter
        }
    }
}