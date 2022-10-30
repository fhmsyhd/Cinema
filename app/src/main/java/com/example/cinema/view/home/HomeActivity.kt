package com.example.cinema.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinema.R
import com.example.cinema.data.data.Resource
import com.example.cinema.data.ui.MovieAdapter
import com.example.cinema.databinding.ActivityHomeBinding
import com.example.cinema.view.detail.DetailActivity
import com.example.cinema.view.detail.DetailActivity.Companion.EXTRA_DATA_MOVIE
import com.example.cinema.view.favorite.FavoriteActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_favorite -> {
                    // Handle favorite icon press
                    startActivity(Intent(this, FavoriteActivity::class.java))
                    true
                }
                else -> false
            }
        }

        supportActionBar?.elevation = 0f

        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(EXTRA_DATA_MOVIE, selectedData)
            startActivity(intent)
        }

        homeViewModel.movie.observe(this) { movie ->
            if (movie != null) {
                when (movie) {
                    is Resource.Loading -> {
                        binding.loadingAnimation.visibility = View.VISIBLE
                        binding.rvMovie.visibility = View.GONE
                    }
                    is Resource.Success -> {
                        binding.loadingAnimation.visibility = View.GONE
                        binding.rvMovie.visibility = View.VISIBLE
                        movieAdapter.setData(movie.data)
                    }
                    is Resource.Error -> {
                        binding.loadingAnimation.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                    }
                }
            }
        }

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}