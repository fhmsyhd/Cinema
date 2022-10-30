package com.example.cinema.data.data.source.local

import com.example.cinema.data.data.source.local.entity.MovieEntity
import com.example.cinema.data.data.source.local.entity.SimilarMovieEntity
import com.example.cinema.data.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovie(): Flow<List<MovieEntity>> = movieDao.getAllMovie()

    fun getAllSimilarMovie(): Flow<List<SimilarMovieEntity>> = movieDao.getAllSimilarMovie()

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)

    suspend fun insertSimilarMovie(movieList: List<SimilarMovieEntity>) = movieDao.insertSimilarMovie(movieList)

    suspend fun deleteSimilarMovie() = movieDao.deleteSimilarMovie()

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}