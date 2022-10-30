package com.example.cinema.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cinema.data.data.Resource
import com.example.cinema.data.domain.model.Movie
import com.example.cinema.data.domain.model.SimilarMovie
import com.example.cinema.data.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

//    val similarMovie = movieUseCase.getAllSimilarMovie().asLiveData()

    fun getSimilarMovie(movieId: String): LiveData<Resource<List<SimilarMovie>>> {
        return movieUseCase.getAllSimilarMovie(movieId).asLiveData()
    }

    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}