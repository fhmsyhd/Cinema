package com.example.cinema.data.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cinema.data.data.source.local.entity.MovieEntity
import com.example.cinema.data.data.source.local.entity.SimilarMovieEntity

@Database(
    entities = [MovieEntity::class, SimilarMovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}