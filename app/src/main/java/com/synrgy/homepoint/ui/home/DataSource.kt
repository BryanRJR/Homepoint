package com.synrgy.homepoint.ui.home

import com.synrgy.homepoint.R
import com.synrgy.homepoint.data.local.model.OfferProduct
import com.synrgy.homepoint.data.local.model.RecommendationProduct
import com.synrgy.homepoint.ui.payment.Delivery
import com.synrgy.homepoint.ui.payment.Order

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

    private val deliveryIcon =
        arrayOf(
            R.drawable.ic_truck_vector,
            R.drawable.ic_drone_payment,
            R.drawable.ic_packet_payment
        )
    private val deliveryTitle = arrayOf(
        "Kurir reguler",
        "Kurir homepoint",
        "Ambil di tempat",
    )
    private val deliveryHarga = arrayOf(
        "Rp25.000",
        "Gratis",
        "Gratis",
    )

    val listDataDelivery: ArrayList<Delivery>
        get() {
            val listDelivery = arrayListOf<Delivery>()
            for (position in deliveryIcon.indices) {
                val menu = Delivery()
                menu.icon = deliveryIcon[position]
                menu.title = deliveryTitle[position]
                menu.harga = deliveryHarga[position]
                listDelivery.add(menu)
            }
            return listDelivery
        }


    private val orderTotal = arrayOf(
        "1x",
        "1x",
        "4x",
    )
    private val orderProduct = arrayOf(
        "Penggorengan Elektronik tanpa minyak / Air Fryer 2.5 L / Microwave Ori",
        "Non-Stick Cookware Set",
        "Gelas Mug Keramik 300ml Hitam Polos",
    )

    private val orderPrice = arrayOf(
        "Rp529.000",
        "Rp115.000",
        "Rp60.000",
    )

    private val orderCheckbox = arrayOf(
        false,
        false,
        false,
    )
    private val tvAssurance = arrayOf(
        "Tampilkan asuransi",
        "Tampilkan asuransi",
        "Tampilkan asuransi",
    )
    private val tvPriceAssurance = arrayOf(
        "Rp100.000",
        "Rp100.000",
        "Rp100.000",
    )


    val listDataOrder: ArrayList<Order>
        get() {
            val listOrder = arrayListOf<Order>()
            for (position in deliveryIcon.indices) {
                val order = Order()
                order.totalOrder = orderTotal[position]
                order.productOrder = orderProduct[position]
                order.priceOrder = orderPrice[position]
                listOrder.add(order)
            }
            return listOrder
        }
}