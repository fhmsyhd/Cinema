package com.example.cinema.view.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.cinema.data.data.MovieRepository
import com.example.cinema.data.data.Resource
import com.example.cinema.data.data.source.local.entity.MovieEntity
import com.example.cinema.data.domain.model.Movie
import com.example.cinema.data.domain.usecase.MovieUseCase
import com.example.cinema.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.flow.Flow
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieUseCase: MovieUseCase

    @Mock
    private lateinit var observer: Observer<Resource<List<Movie>>>

    @Before
    fun setUp() {
        viewModel = HomeViewModel(movieUseCase)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.Success(DataDummy.generateDummyMovies())
        val movies = MutableLiveData<Resource<List<MovieEntity>>>()
        movies.value = dummyMovie

        `when`(movieRepository.getAllMovie()).thenReturn(movies as Flow<Resource<List<Movie>>>)
        val movie = viewModel.movie.value?.data
        verify(movieRepository).getAllMovie()
        assertNotNull(movie)
//        assertEquals(5, movie)

        viewModel.movie.observeForever(observer)
//        verify(observer).onChanged(dummyMovie)
    }
}