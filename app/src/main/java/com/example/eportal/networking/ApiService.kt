package com.example.eportal.networking

import com.example.eportal.model.RecipesResponse
import com.example.eportal.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") key: String = ApiConfig.API_KEY,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): Call<WeatherResponse>

    //Rapid APIs
    @GET("recipes/list")
    fun getRecipesList(
        @Header("X-RapidAPI-Key") key : String = ApiConfig.RAPID_API_KEY,
        @Query("from") from : Int = 0,
        @Query("size") size : Int = 20,
        //@Query("q") q : String = "Blueberry Cream Muffin"
    ) : Call<RecipesResponse>
}