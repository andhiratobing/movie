package com.andhiratobing.movieapp.presentation.fragments.home.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andhiratobing.domain.common.ResourceState
import com.andhiratobing.domain.interactor.MovieUseCase
import com.andhiratobing.domain.models.MovieDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {


    private var _movieMutableStateFlow =
        MutableStateFlow<ResourceState<Triple<List<MovieDomain>, List<MovieDomain>, List<MovieDomain>>>>(
            ResourceState.Empty
        )
    val movieStateFlow: StateFlow<ResourceState<Triple<List<MovieDomain>, List<MovieDomain>, List<MovieDomain>>>> get() = _movieMutableStateFlow


    fun fetchPopularMovie() {
        viewModelScope.launch {
            val popularMovie = movieUseCase.popularMovieUseCase.execute()
                .onEach {
                    _movieMutableStateFlow.value = ResourceState.Loading
                }
            val nowPlayingMovie = movieUseCase.nowPlayingMovieUseCase.execute()
                .onEach {
                    _movieMutableStateFlow.value = ResourceState.Loading
                }
            val upComingMovie = movieUseCase.upComingMovieUseCase.execute()
                .onEach {
                    _movieMutableStateFlow.value = ResourceState.Loading
                }
            combine(popularMovie, nowPlayingMovie, upComingMovie) { popular, nowPlaying, upComing ->
                Triple(popular, nowPlaying, upComing)
            }
                .catch {
                    _movieMutableStateFlow.value = ResourceState.Error(it.message)
                }
                .collect {
                    _movieMutableStateFlow.value = ResourceState.Success(it)

                }
        }
    }


}