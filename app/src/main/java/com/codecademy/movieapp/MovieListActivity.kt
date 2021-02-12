package com.codecademy.movieapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.codecademy.movieapp.repository.Repository

class MovieListActivity : BaseActivity() {
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {response ->
            if(response.isSuccessful) {
                Log.d("Response", response.body()?.page.toString())
                Log.d("Response", response.body()?.results.toString())
                Log.d("Response", response.body()?.total_pages.toString())
                Log.d("Response", response.body()?.total_results.toString())
            }else{
                Log.d("Response", response.errorBody().toString())
                findViewById<TextView>(R.id.test).text = response.code().toString()
            }
        })

    }
}