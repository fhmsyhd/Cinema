package com.example.cinema.view.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cinema.data.domain.usecase.MovieUseCase

class FavoriteMovieViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}