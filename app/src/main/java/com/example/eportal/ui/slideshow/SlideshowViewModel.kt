package com.example.eportal.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val usersList : ArrayList<User> = arrayListOf(
        User( "Janelle Hicks","Waterloo"),
        User("Maddox Kirk", "Kitchener"),
        User("Ellis McBride","Waterloo")
    )

    /*
    ,
    "Denver Cobb",
    "Aviana Ochoa",
    "Winston Reed",
    "Valentina Perkins",
    "Kyrie Buckley",
    "Theodora Monroe",
    "Colby Ayers",
    "Simone Guevara",
    "Tommy Mullen",
    "Shay Mullins",
    "Allen Moses",
    "Karter Wang",
    "Cohen Gaines",
    "Aya Moody",
    "Ryland Chen"*/
    //val recyclerView : ArrayList<String> = ArrayList()

    val text: LiveData<String> = _text


}