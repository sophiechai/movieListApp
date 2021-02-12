package com.codecademy.movieapp.repository

import com.codecademy.movieapp.api.RetrofitInstance
import com.codecademy.movieapp.models.CurrentMovie
import retrofit2.Response

class Repository {
    suspend fun getPost() : Response<CurrentMovie>{
        return RetrofitInstance.api.getPost()
    }
}