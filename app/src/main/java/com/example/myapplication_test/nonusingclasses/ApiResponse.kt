package com.example.myapplication_test.nonusingclasses

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("cards") val cards: List<CardItem>
)

data class CardItem(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val imageUrl: String
)