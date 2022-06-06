package com.synrgy.homepoint.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.synrgy.homepoint.R
import com.synrgy.homepoint.data.local.model.OfferProduct
import com.synrgy.homepoint.data.local.model.RecommendationProduct
import com.synrgy.homepoint.databinding.FragmentHomeBinding
import com.synrgy.homepoint.ui.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(){

    private lateinit var offerAdapter: OfferAdapter
    private var listOfferProduct: ArrayList<OfferProduct> = arrayListOf()

    private lateinit var recommendationAdapter: RecommendationAdapter
    private var listRecommendationProduct: ArrayList<RecommendationProduct> = arrayListOf()

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        setupRecyclerViewOffer()
        setupRecyclerViewRecommendation()
    }

    private fun initViewPager(){
        val ivBanner = listOf(
            R.drawable.img_banner_1,
            R.drawable.img_banner_2,
            R.drawable.img_banner_3,
        )

        binding.pagerSlider.adapter = ViewPagerAdapter(ivBanner)
        binding.pagerSlider.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.pagerSlider.currentItem = 0
        binding.pagerSlider.offscreenPageLimit = 2
    }

    private fun setupRecyclerViewOffer(){
        listOfferProduct.addAll(DataSource.listOfferProduct)
        offerAdapter = OfferAdapter(listOfferProduct)
        binding.rvOffer.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = offerAdapter
        }
    }

    private fun setupRecyclerViewRecommendation(){
        listRecommendationProduct.addAll(DataSource.listRecommendationProduct)
        recommendationAdapter = RecommendationAdapter(listRecommendationProduct)
        binding.rvRecommendation.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = recommendationAdapter
        }
    }
}