package com.example.myapplication_test.nonusingclasses

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication_test.R
import com.example.myapplication_test.databinding.CardItemBinding

class MyAdapter: RecyclerView.Adapter<MyAdapter.MainViewHolder>() {

    private var data: List<Ads> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size

    fun setData(newData: List<Ads>) {
        data = newData
        notifyDataSetChanged()
    }
        class MainViewHolder(private val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Ads) {
                binding.titleTextView.text = item.ajio440869374Dkbrown.ad
                binding.imageView.loadImage(item.ajio440869374Dkbrown.mod.surl[0])
                binding.button.setOnClickListener {
                    // Handle button click here
                }
            }

        private fun ImageView.loadImage(url: String) {
            Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.color.colorPrimary) // Placeholder color or image
                .into(this)
        }
    }
}