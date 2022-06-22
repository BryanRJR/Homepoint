package com.synrgy.homepoint.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.synrgy.homepoint.databinding.ItemListOrderBinding

class OrderAdapter(private val listOrder: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderAdapter.OrderViewHolder {
        val binding = ItemListOrderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrderViewHolder(binding)
    }

    override fun getItemCount(): Int = listOrder.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
       holder.bind(listOrder[position])

    }

    inner class OrderViewHolder(private val binding: ItemListOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Order) {
            binding.tvTotalOrder.text = item.totalOrder
            binding.tvProductOrder.text = item.productOrder
            binding.tvPriceOrder.text = item.priceOrder
        }
    }


}