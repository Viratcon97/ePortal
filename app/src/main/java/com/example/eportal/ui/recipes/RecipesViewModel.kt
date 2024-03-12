package com.example.eportal.ui.recipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eportal.model.RecipesResponse
import com.example.eportal.networking.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesViewModel : ViewModel() {

    private val _recipesData = MutableLiveData<RecipesResponse>()
    val recipesData: LiveData<RecipesResponse> get() = _recipesData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> get() = _isError

    private var errorMessage: String = ""

    fun getRecipesList() {

        _isLoading.value = true
        _isError.value = false

        val client = ApiConfig.getRapidApiService().getRecipesList()

        client.enqueue(object : Callback<RecipesResponse> {

            override fun onResponse(
                call: Call<RecipesResponse>,
                response: Response<RecipesResponse>
            ) {
                val responseBody = response.body()
                if (!response.isSuccessful || responseBody == null) {
                    onError("Data Processing Error")
                    return
                }

                _isLoading.value = false
                _recipesData.postValue(responseBody!!)
            }

            override fun onFailure(call: Call<RecipesResponse>, t: Throwable) {
                onError(t.message)
                t.printStackTrace()
            }

        })
    }
    private fun onError(inputMessage: String?) {

        val message = if (inputMessage.isNullOrBlank() or inputMessage.isNullOrEmpty()) "Unknown Error"
        else inputMessage

        errorMessage = StringBuilder("ERROR: ")
            .append("$message some data may not displayed properly").toString()

        _isError.value = true
        _isLoading.value = false
    }
}