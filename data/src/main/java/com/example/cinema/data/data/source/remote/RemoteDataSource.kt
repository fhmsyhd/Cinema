package com.example.cinema.data.data.source.remote

import android.util.Log
import com.example.cinema.data.data.source.remote.network.ApiResponse
import com.example.cinema.data.data.source.remote.network.ApiService
import com.example.cinema.data.data.source.remote.response.MovieResponse
import com.example.cinema.data.data.source.remote.response.SimilarMovieResponse
import com.example.cinema.data.utils.Constant.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        // get data from remote api
        return flow {
            try {
                val response = apiService.getListMovieNowPlaying(API_KEY)
                val dataArray = response.result
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllSimilarMovie(movieId: String): Flow<ApiResponse<List<SimilarMovieResponse>>> {
        // get data from remote api
        return flow {
            try {
                val response = apiService.getListSimilarMovie(movieId, API_KEY)
                val dataArray = response.result
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}