package com.example.cinema.data.utils

import com.example.cinema.data.data.source.local.entity.MovieEntity
import com.example.cinema.data.data.source.local.entity.SimilarMovieEntity
import com.example.cinema.data.data.source.remote.response.MovieResponse
import com.example.cinema.data.data.source.remote.response.SimilarMovieResponse
import com.example.cinema.data.domain.model.Movie
import com.example.cinema.data.domain.model.SimilarMovie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        title = input.title,
        overview = input.overview,
        releaseDate = input.releaseDate,
        posterPath = input.posterPath,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
        isFavorite = input.isFavorite
    )

    fun mapSimilarResponsesToEntities(input: List<SimilarMovieResponse>): List<SimilarMovieEntity> {
        val movieList = ArrayList<SimilarMovieEntity>()
        input.map {
            val movie = SimilarMovieEntity(
                movieId = it.id,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapSimilarEntitiesToDomain(input: List<SimilarMovieEntity>): List<SimilarMovie> =
        input.map {
            SimilarMovie(
                movieId = it.movieId,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath.toString(),
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = it.isFavorite
            )
        }

    fun SimilarMovie.toMovie(): Movie {
        return Movie(
            movieId = movieId,
            title = title,
            overview = overview,
            releaseDate = releaseDate,
            posterPath = posterPath,
            popularity = popularity,
            voteAverage = voteAverage,
            voteCount = voteCount,
            isFavorite = isFavorite
        )
    }

    fun mapSimilarDomainToEntity(input: SimilarMovie) = SimilarMovieEntity(
        movieId = input.movieId,
        title = input.title,
        overview = input.overview,
        releaseDate = input.releaseDate,
        posterPath = input.posterPath,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
        isFavorite = input.isFavorite
    )
}