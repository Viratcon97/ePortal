package com.example.eportal.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val recyclerView : ArrayList<String> = arrayListOf<String>("Alpha","Beta","Alpha","Beta","Alpha","Beta","Alpha","Beta")
    //val recyclerView : ArrayList<String> = ArrayList()

    val text: LiveData<String> = _text
}