package com.example.eportal.ui.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {


    /*private val _text = MutableLiveData<String>().apply {
        value = "This is profile Fragment"
    }
    val text: LiveData<String> = _text*/

    val name = MutableLiveData<String>()
    val city = MutableLiveData<String>()
    fun displayText() {
        Log.d("DATA","Name in ViewModel"+name.value.toString())
    }

}