package com.example.cinema.data.utils

object Constant {

    // Uri Api
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val END_POINT_NOW_PLAYING = "movie/now_playing"
    const val END_POINT_SIMILAR_MOVIE = "movie/{movie_id}/similar"
    const val API_KEY = "9109b2a2aa9336ea2595ace2f8ea18c0"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"

    // Entity
    const val DB_MOVIE = "Movie.db"
    const val TABLE_MOVIE = "movie"
    const val TABLE_SIMILAR_MOVIE = "similarMovie"
}