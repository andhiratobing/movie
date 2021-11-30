package com.andhiratobing.movieapp.presentation.fragments.home.movie.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.andhiratobing.domain.common.ResourceState
import com.andhiratobing.domain.interactor.movie.paging.popular_movie.PopularMoviePagingUseCase
import com.andhiratobing.domain.models.MovieDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviePagingViewModel @Inject constructor(
    private val moviePagingUseCase: PopularMoviePagingUseCase
) : ViewModel() {

    private var _popularMoviePaging =
        MutableStateFlow<ResourceState<PagingData<MovieDomain>>>(ResourceState.Empty)
    val popularMoviePaging: StateFlow<ResourceState<PagingData<MovieDomain>>> get() = _popularMoviePaging


    fun getAllPopularMovie() =
        viewModelScope.launch {
            moviePagingUseCase.execute()
                .onEach {
                    _popularMoviePaging.value = ResourceState.Loading
                }.catch {
                    _popularMoviePaging.value = ResourceState.Error(it.message)
                }
                .collect {
                    _popularMoviePaging.value = ResourceState.Success(it)
                }

        }
}