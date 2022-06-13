package com.synrgy.homepoint.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.synrgy.homepoint.data.local.model.OfferProduct
import com.synrgy.homepoint.databinding.OfferCardItemBinding

class OfferAdapter(private val listOfferProduct: List<OfferProduct>) : RecyclerView.Adapter<OfferAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferAdapter.ViewHolder {
        val binding = OfferCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OfferAdapter.ViewHolder, position: Int) {
        holder.bind(listOfferProduct[position])
    }

    override fun getItemCount(): Int = listOfferProduct.size

    inner class ViewHolder(private val binding: OfferCardItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: OfferProduct){
            with(binding){
                ivProduct.setImageResource(data.image)
                tvTitleProduct.text = data.title
                tvPriceProduct.text = data.price
                tvRating.text = data.rating
                tvSold.text = "Terjual ${data.sold}"
            }
        }
    }

}