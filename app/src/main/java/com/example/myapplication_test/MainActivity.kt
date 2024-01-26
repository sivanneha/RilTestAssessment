package com.example.myapplication_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView

class MainActivity : AppCompatActivity() {
    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer
    private val viewModel: VideoViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    val cardViewModel: CardViewModel by viewModels()
    private val cardAdapter = CardAdapter(emptyList())
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        player = SimpleExoPlayer.Builder(this, DefaultRenderersFactory(this)).build()
        playerView = findViewById(R.id.playerView)
        playerView.player = player

        val mediaItem =
            MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")

        player.setMediaItem(mediaItem)
        player.prepare()
        viewModel.isPlaying.observe(this, Observer { isPlaying ->
            if (isPlaying) {
                player.play()
            } else {
                player.pause()
            }
        })
        playerView.setOnClickListener {
            viewModel.togglePlayback()
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = cardAdapter
        try {
            cardViewModel.cardList.observe(this, Observer { cards ->
                cards?.let {
                    Log.d("MainActivity", "Received new data size: ${it.size}")
                    cardAdapter.updateData(it)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
        button = findViewById(R.id.seeAllButton)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        playerView.onResume()
    }

    override fun onStop() {
        super.onStop()
        playerView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}