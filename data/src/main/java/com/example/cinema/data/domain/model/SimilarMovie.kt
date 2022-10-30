package com.example.cinema.data.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SimilarMovie(
    val movieId: String,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int,
    val isFavorite: Boolean
) : Parcelable

