package com.example.cinema.di

import com.example.cinema.data.domain.usecase.MovieInteractor
import com.example.cinema.data.domain.usecase.MovieUseCase
import com.example.cinema.view.detail.DetailViewModel
import com.example.cinema.view.favorite.FavoriteMovieViewModel
import com.example.cinema.view.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}