package com.andhiratobing.movieapp.presentation.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andhiratobing.movieapp.domain.common.ResourceState
import com.andhiratobing.movieapp.domain.interactor.popular_movie.PopularMovieUseCase
import com.andhiratobing.movieapp.domain.models.MovieDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val popularMovieUseCase: PopularMovieUseCase
) : ViewModel() {


    private var _popularMovieMutableStateFlow = MutableStateFlow<ResourceState<List<MovieDomain>?>>(ResourceState.Empty)
    val popularMovieStateFlow: StateFlow<ResourceState<List<MovieDomain>?>> get() = _popularMovieMutableStateFlow


    fun fetchPopularMovie() {
        viewModelScope.launch {
            popularMovieUseCase.execute()
                .onEach {
                    _popularMovieMutableStateFlow.value = ResourceState.Loading
                }
                .catch {
                    _popularMovieMutableStateFlow.value = ResourceState.Error(it.message)
                }
                .collect {
                    _popularMovieMutableStateFlow.value = ResourceState.Success(it)

                }
        }
    }



}