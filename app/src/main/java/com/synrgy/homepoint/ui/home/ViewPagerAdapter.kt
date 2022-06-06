package com.synrgy.homepoint.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.synrgy.homepoint.databinding.BannerItemBinding

class ViewPagerAdapter(private val list: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewPagerViewHolder(private val binding: BannerItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(imgPhoto: Int) {
            with(binding){
                ivBanner.setImageResource(imgPhoto)
            }
        }
    }
}