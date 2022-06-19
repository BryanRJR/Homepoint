package com.synrgy.homepoint.ui.home

import com.synrgy.homepoint.R
import com.synrgy.homepoint.data.local.model.OfferProduct
import com.synrgy.homepoint.data.local.model.RecommendationProduct

object DataSource {
    private val imageProduct = arrayOf(
        R.drawable.img_offer_1,
        R.drawable.img_offer_2,
        R.drawable.img_offer_3,
        R.drawable.img_offer_4
    )

    private val titleProduct = arrayOf("Gelas Kaca Bening Biru", "Gelas Kaca Hitam Pekat", "Gelas Kaca Putih Bersih", "Gelas Kaca Coklat Bersih")
    private val priceProduct = arrayOf("Rp. 23.000", "Rp. 26.000", "Rp. 33.000", "Rp. 18.000")
    private val ratingProduct = arrayOf("4.8", "4.6", "6.9", "4.8")
    private val soldProduct = arrayOf("79", "93", "19", "46")

    val listOfferProduct: ArrayList<OfferProduct>
        get() {
            val list = arrayListOf<OfferProduct>()
            for (position in titleProduct.indices){
                val product = OfferProduct()
                product.image = imageProduct[position]
                product.title = titleProduct[position]
                product.price = priceProduct[position]
                product.rating = ratingProduct[position]
                product.sold = soldProduct[position]
                list.add(product)
            }
            return list
        }

    val listRecommendationProduct: ArrayList<RecommendationProduct>
        get() {
            val list = arrayListOf<RecommendationProduct>()
            for (position in titleProduct.indices){
                val product = RecommendationProduct()
                product.image = imageProduct[position]
                product.title = titleProduct[position]
                product.price = priceProduct[position]
                product.rating = ratingProduct[position]
                product.sold = soldProduct[position]
                list.add(product)
            }
            return list
        }
}