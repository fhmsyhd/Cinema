package com.example.cinema.data.data

import com.example.cinema.data.data.source.local.LocalDataSource
import com.example.cinema.data.data.source.remote.RemoteDataSource
import com.example.cinema.data.data.source.remote.network.ApiResponse
import com.example.cinema.data.data.source.remote.response.MovieResponse
import com.example.cinema.data.data.source.remote.response.SimilarMovieResponse
import com.example.cinema.data.domain.model.Movie
import com.example.cinema.data.domain.model.SimilarMovie
import com.example.cinema.data.domain.repository.IMovieRepository
import com.example.cinema.data.utils.AppExecutors
import com.example.cinema.data.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {

    override fun getAllMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(){
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }
        }.asFlow()

    override fun getAllSimilarMovie(movieId: String): Flow<Resource<List<SimilarMovie>>> =
        object : NetworkBoundResource<List<SimilarMovie>, List<SimilarMovieResponse>>(){
            override fun loadFromDB(): Flow<List<SimilarMovie>> {
                return localDataSource.getAllSimilarMovie().map {
                    DataMapper.mapSimilarEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<SimilarMovie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<SimilarMovieResponse>>> =
                remoteDataSource.getAllSimilarMovie(movieId)

            override suspend fun saveCallResult(data: List<SimilarMovieResponse>) {
                localDataSource.deleteSimilarMovie()
                val movieList = DataMapper.mapSimilarResponsesToEntities(data)
                localDataSource.insertSimilarMovie(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state)}
    }
}