package com.example.myapplication_test

import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication_test.databinding.ItemLayoutBinding

class DataAdapter(private var data: List<CardModel>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val firstItemPosition = position * 2
        val secondItemPosition = position * 2 + 1

        holder.binding.cardView1.visibility = View.VISIBLE
        holder.binding.cardView2.visibility = View.VISIBLE

        if (firstItemPosition < data.size) {
            val item1 = data[firstItemPosition]

            Glide.with(holder.itemView.context)
                .load(item1.imageUrl)
                .into(holder.binding.imageView1)

            holder.binding.titleTextView1.text = item1.title
            holder.binding.discountPercentageTextView1.text = item1.disPer
            holder.binding.salePriceTextView1.text = item1.salePrice
            holder.binding.priceTextView1.text = item1.price
            holder.binding.priceTextView1.setPaintFlags(holder.binding.priceTextView2.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            holder.binding.button1.text = item1.ctaText
        } else {
            holder.binding.cardView1.visibility = View.INVISIBLE
        }

        if (secondItemPosition < data.size) {
            val item2 = data[secondItemPosition]

            Glide.with(holder.itemView.context)
                .load(item2.imageUrl)
                .into(holder.binding.imageView2)

            holder.binding.titleTextView2.text = item2.title
            holder.binding.discountPercentageTextView2.text = item2.disPer
            holder.binding.salePriceTextView2.text = item2.salePrice
            holder.binding.priceTextView2.text = item2.price
            holder.binding.priceTextView2.setPaintFlags(holder.binding.priceTextView2.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            holder.binding.button2.text = item2.ctaText
        } else {
            holder.binding.cardView2.visibility = View.INVISIBLE
        }

        // Handle button click or other interactions as needed
    }

    override fun getItemCount(): Int {
        return (data.size + 1) / 2 // Calculate the number of rows
    }

    fun updateData(newCardList: List<CardModel>) {
        Handler(Looper.getMainLooper()).post {
            data = newCardList
            notifyDataSetChanged()
        }
    }
}