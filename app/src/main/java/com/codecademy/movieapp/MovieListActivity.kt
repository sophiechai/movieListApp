package com.codecademy.movieapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.codecademy.movieapp.repository.Repository
import com.google.android.material.bottomnavigation.BottomNavigationView

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
                findViewById<TextView>(R.id.tvFirstFragment).text = response.code().toString()
            }
        })

        val homeFragment = HomeFragment();
        val searchFragment = SearchFragment();
        val favoritesFragment = FavoritesFragment();
        val profileFragment = ProfileFragment();
        val navigationView : BottomNavigationView = findViewById(R.id.bottomNavigationView)

        setCurrentFragment(homeFragment)

        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miSearch -> setCurrentFragment(searchFragment)
                R.id.miFavorite -> setCurrentFragment(favoritesFragment)
                R.id.miProfile -> setCurrentFragment(profileFragment)
            }
            true;
        }
        navigationView.getOrCreateBadge(R.id.miFavorite).apply {
            number = 0
        }



    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flHome, fragment)
            commit()
        }
}