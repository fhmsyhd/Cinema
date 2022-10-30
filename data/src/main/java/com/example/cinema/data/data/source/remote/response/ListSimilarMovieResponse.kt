package com.example.cinema.data.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSimilarMovieResponse (
    @field:SerializedName("page")
    val page: String,

    @field:SerializedName("total_pages")
    val description: Int,

    @field:SerializedName("results")
    val result: List<SimilarMovieResponse>
)