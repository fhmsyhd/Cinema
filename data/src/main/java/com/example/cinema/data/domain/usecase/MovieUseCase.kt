package com.example.cinema.data.domain.usecase

import com.example.cinema.data.data.Resource
import com.example.cinema.data.domain.model.Movie
import com.example.cinema.data.domain.model.SimilarMovie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getAllSimilarMovie(movieId: String): Flow<Resource<List<SimilarMovie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}