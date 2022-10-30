package com.example.cinema.view.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinema.data.ui.MovieAdapter
import com.example.cinema.databinding.ActivityFavoriteBinding
import com.example.cinema.view.detail.DetailActivity
import com.example.cinema.view.detail.DetailActivity.Companion.EXTRA_DATA_MOVIE
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    private val favoriteMovieVieModel: FavoriteMovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener { finish() }

        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(EXTRA_DATA_MOVIE, selectedData)
            startActivity(intent)
        }

        favoriteMovieVieModel.favoriteMovie.observe(this) { dataMovie ->
            movieAdapter.setData(dataMovie)
            binding.viewEmpty.root.visibility =
                if (dataMovie.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}