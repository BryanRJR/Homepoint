package com.synrgy.homepoint.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.synrgy.homepoint.databinding.ItemDeliveryBinding

class PaymentAdapter(private val listDelivery: List<Delivery>) :
    RecyclerView.Adapter<PaymentAdapter.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemDeliveryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int = listDelivery.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) = holder.bind(listDelivery[position])

    inner class MenuViewHolder(private val binding: ItemDeliveryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Delivery) {
            binding.iconDelivery.setImageResource(item.icon)
            binding.tvTitleDelivery.text = item.title
            binding.tvHargaDelivery.text = item.harga
        }
    }

}