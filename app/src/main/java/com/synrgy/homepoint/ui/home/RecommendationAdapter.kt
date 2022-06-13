package com.synrgy.homepoint.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.synrgy.homepoint.data.local.model.RecommendationProduct
import com.synrgy.homepoint.databinding.OfferCardItemBinding

class RecommendationAdapter(private val listRecommendationProduct: List<RecommendationProduct>) : RecyclerView.Adapter<RecommendationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = OfferCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listRecommendationProduct[position])
    }

    override fun getItemCount(): Int = listRecommendationProduct.size

    inner class ViewHolder(private val binding: OfferCardItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: RecommendationProduct){
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