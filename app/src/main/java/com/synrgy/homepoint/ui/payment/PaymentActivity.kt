package com.synrgy.homepoint.ui.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.synrgy.homepoint.databinding.ActivityPaymentBinding
import com.synrgy.homepoint.ui.home.DataSource

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    private var listDelivery: ArrayList<Delivery> = arrayListOf()
    private var listOrder : ArrayList<Order> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerViewDelivery()

        setRecyclerViewOrder()
    }
    private fun setRecyclerViewOrder(){
        listOrder.addAll(DataSource.listDataOrder)
        binding.rvOrderList.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = OrderAdapter(listOrder)
        }

    }

    private fun setRecyclerViewDelivery() {
        listDelivery.addAll(DataSource.listDataDelivery)
        binding.rvDelivery.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = PaymentAdapter(listDelivery)
        }
    }
}