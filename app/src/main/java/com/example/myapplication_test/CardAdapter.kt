package com.example.myapplication_test

import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication_test.databinding.CardItemBinding

class CardAdapter(private var cardList: List<CardModel>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]
        Glide.with(holder.itemView.context)
            .load(card.imageUrl)
            .into(holder.binding.imageView)

        holder.binding.titleTextView.text = card.title
        holder.binding.discountPercentageTextView.text = card.disPer
        holder.binding.salePriceTextView.text = card.salePrice
        holder.binding.priceTextView.text = card.price
        holder.binding.priceTextView.setPaintFlags(holder.binding.priceTextView.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
        holder.binding.button.text = card.ctaText
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    fun updateData(newCardList: List<CardModel>) {
        Handler(Looper.getMainLooper()).post {
            cardList = newCardList
            notifyDataSetChanged()
        }
    }
}