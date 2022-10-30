package com.example.cinema.view.detail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.cinema.R
import com.example.cinema.data.data.Resource
import com.example.cinema.data.domain.model.Movie
import com.example.cinema.data.ui.SimilarMovieAdapter
import com.example.cinema.data.utils.Constant.IMAGE_URL
import com.example.cinema.data.utils.DataMapper.toMovie
import com.example.cinema.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_MOVIE = "extra_data_movie"
    }

    private lateinit var binding: ActivityDetailBinding

    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA_MOVIE)
        showDetailMovie(detailMovie)

        val movieAdapter = SimilarMovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(EXTRA_DATA_MOVIE, selectedData.toMovie())
            startActivity(intent)
        }

        detailMovie?.movieId?.let {
            detailViewModel.getSimilarMovie(it).observe(this) { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> {
                            binding.rvMovie.visibility = View.GONE
                        }
                        is Resource.Success -> {
                            binding.rvMovie.visibility = View.VISIBLE
                            movieAdapter.setData(movie.data)
                        }
                        is Resource.Error -> {
                            binding.layoutSimilar.visibility = View.GONE
                        }
                    }
                }
            }
        }


        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    @SuppressLint("SetTextI18n", "StringFormatInvalid")
    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            Glide.with(this)
                .load(IMAGE_URL + detailMovie.posterPath)
                .into(binding.imgMovie)
            binding.tvTitle.text = detailMovie.title
            binding.tvRating.text = "Rating : " + detailMovie.voteAverage.toString()
            binding.tvRelease.text = detailMovie.releaseDate
            binding.tvPopularity.text = detailMovie.popularity.toString()
            binding.tvAgeRating.text = detailMovie.voteCount.toString()
            binding.tvOverview.text = detailMovie.overview

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fabFavorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

            binding.btnShare.setOnClickListener {
                ShareCompat.IntentBuilder.from(this)
                    .setType("text/plain")
                    .setChooserTitle("Share to friend")
                    .setText(getString(R.string.share_movie, detailMovie.title))
                    .startChooser()
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_loved))
        } else {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_love))
        }
    }
}