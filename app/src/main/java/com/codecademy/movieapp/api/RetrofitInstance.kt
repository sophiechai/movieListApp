package com.codecademy.movieapp.api

import com.codecademy.movieapp.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api : JsonPlaceApi by lazy{
        retrofit.create(JsonPlaceApi::class.java)
    }
}