package com.example.myapplication_test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class CardViewModel : ViewModel() {

    private val _cardList = MutableLiveData<List<CardModel>>()
    val cardList: LiveData<List<CardModel>> get() = _cardList

    init {
        fetchData()
    }

    private fun fetchData() {
        val jsonUrl = "https://jioads.akamaized.net/test/androidTest/response.json"

        // coroutine to fetch and parse data
        try {
            GlobalScope.launch(Dispatchers.Main) {
                val jsonString = fetchDataFromUrl(jsonUrl)
                Log.d("CardViewModel", "JSON Response: $jsonString")
                val cards = parseJson(jsonString)
                Log.d("CardViewModel", "Parsed Cards: $cards")
                _cardList.postValue(cards)
            }
        } catch (e: Exception) {
            Log.e("CardViewModel", "Error fetching data: ${e.message}", e)
        }
    }

    suspend fun fetchDataFromUrl(urlString: String): String {
        return withContext(Dispatchers.IO) {
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection

            try {
                connection.requestMethod = "GET"
                connection.connectTimeout = 5000

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
                    val response = StringBuilder()

                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        response.append(line).append('\n')
                    }

                    reader.close()
                    response.toString()
                } else {
                    throw Exception("Error: ${connection.responseCode} ${connection.responseMessage}")
                }
            } finally {
                connection.disconnect()
            }
        }
    }

    private fun parseJson(jsonString: String): List<CardModel> {
        val cardList = mutableListOf<CardModel>()

        try {
            val jsonArray = JSONArray(jsonString)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val title = jsonObject.getString("title")
                val salePrice = jsonObject.getString("salePrice")
                val price = jsonObject.getString("price")
                val disPer = jsonObject.getString("disPer")
                val ctaText = jsonObject.getString("ctaText")
                val ctafb = jsonObject.getString("ctafb")
                val imageUrl = jsonObject.getString("imageUrl")

                cardList.add(CardModel(title, salePrice, price, disPer, ctaText, ctafb, imageUrl))
                Log.d("CardViewModel", "Parsed Cards: $cardList")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("CardViewModel", "Error parsing JSON: ${e.message}", e)
        }

        return cardList
    }
}