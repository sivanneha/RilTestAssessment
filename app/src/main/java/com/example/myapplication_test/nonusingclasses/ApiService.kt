package com.example.myapplication_test.nonusingclasses

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("androidTest/response.json")
    suspend fun getCardItems(): Result

    companion object {
        private const val BASE_URL = "https://jioads.akamaized.net/test/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}