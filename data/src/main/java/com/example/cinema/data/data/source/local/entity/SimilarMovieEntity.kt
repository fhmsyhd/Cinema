package com.example.cinema.data.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cinema.data.utils.Constant.TABLE_SIMILAR_MOVIE

@Entity(tableName = TABLE_SIMILAR_MOVIE)
data class SimilarMovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = null,

    @ColumnInfo(name = "popularity")
    var popularity: Double,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double,

    @ColumnInfo(name = "voteCount")
    var voteCount: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)