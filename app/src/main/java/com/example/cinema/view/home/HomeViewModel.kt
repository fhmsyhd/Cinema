package com.example.cinema.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cinema.data.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val movie = movieUseCase.getAllMovie().asLiveData()
}