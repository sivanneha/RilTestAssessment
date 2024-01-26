package com.example.myapplication_test

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        recyclerView = findViewById(R.id.recyclerView2)
        val cardViewModel: CardViewModel by viewModels()
        val dataAdapter = DataAdapter(emptyList())

        val linearLayoutManager = LinearLayoutManager(
            this
        )
        linearLayoutManager.orientation =
            LinearLayoutManager.HORIZONTAL // set Horizontal Orientation

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = dataAdapter

        try {
            cardViewModel.cardList.observe(this, Observer { cards ->
                cards?.let {
                    Log.d("MainActivity", "Received new data size: ${it.size}")
                    dataAdapter.updateData(it)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}