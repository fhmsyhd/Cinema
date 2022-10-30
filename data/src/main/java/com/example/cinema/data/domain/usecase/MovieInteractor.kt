package com.example.cinema.data.domain.usecase

import com.example.cinema.data.domain.model.Movie
import com.example.cinema.data.domain.repository.IMovieRepository

class MovieInteractor(private val  movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getAllSimilarMovie(movieId: String) = movieRepository.getAllSimilarMovie(movieId)

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) = movieRepository.setFavoriteMovie(movie, state)

}