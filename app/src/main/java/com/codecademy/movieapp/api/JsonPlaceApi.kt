package com.codecademy.movieapp.api

import com.codecademy.movieapp.models.CurrentMovie
import com.codecademy.movieapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonPlaceApi {

    @GET("movie/now_playing")
    suspend fun getPost(@Query("api_key") apiKey: String  = Constants.API_KEY) : Response<CurrentMovie>

}