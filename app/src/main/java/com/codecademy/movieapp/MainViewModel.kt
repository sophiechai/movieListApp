package com.codecademy.movieapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codecademy.movieapp.models.CurrentMovie
import com.codecademy.movieapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<CurrentMovie>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch{
            val response = repository.getPost()
            myResponse.value = response


        }
    }
}