package com.example.cinema.data.data.source.local.room

import androidx.room.*
import com.example.cinema.data.data.source.local.entity.MovieEntity
import com.example.cinema.data.data.source.local.entity.SimilarMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM similarMovie")
    fun getAllSimilarMovie(): Flow<List<SimilarMovieEntity>>

    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSimilarMovie(movie: List<SimilarMovieEntity>)

    @Query("DELETE FROM similarMovie")
    suspend fun deleteSimilarMovie()

    @Update
    fun updateFavoriteMovie(movie: MovieEntity)
}