package com.example.cinema.data.data.source.remote.network

import com.example.cinema.data.data.source.remote.response.ListMovieResponse
import com.example.cinema.data.data.source.remote.response.ListSimilarMovieResponse
import com.example.cinema.data.utils.Constant.END_POINT_NOW_PLAYING
import com.example.cinema.data.utils.Constant.END_POINT_SIMILAR_MOVIE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(END_POINT_NOW_PLAYING)
    suspend fun getListMovieNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US"
    ): ListMovieResponse

    @GET(END_POINT_SIMILAR_MOVIE)
    suspend fun getListSimilarMovie(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: String = "1"
    ): ListSimilarMovieResponse
}