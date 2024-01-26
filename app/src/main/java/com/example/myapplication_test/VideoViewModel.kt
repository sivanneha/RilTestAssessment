package com.example.myapplication_test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VideoViewModel : ViewModel() {
    val isPlaying = MutableLiveData<Boolean>()

    init {
        isPlaying.value = false
    }

    fun togglePlayback() {
        isPlaying.value = isPlaying.value?.not()
    }
}