package com.andhiratobing.movieapp.presentation.fragments.home.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andhiratobing.domain.common.ResourceState
import com.andhiratobing.domain.interactor.tv_shows.TvShowsUseCase
import com.andhiratobing.domain.models.TvShowsDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(
    private val tvShowsUseCase: TvShowsUseCase
) : ViewModel() {

    private var _tvShowMutableStateFlow =
        MutableStateFlow<ResourceState<Triple<List<TvShowsDomain>, List<TvShowsDomain>, List<TvShowsDomain>>>>(
            ResourceState.Empty
        )
    val tvShowStateFlow: StateFlow<ResourceState<Triple<List<TvShowsDomain>, List<TvShowsDomain>, List<TvShowsDomain>>>> get() = _tvShowMutableStateFlow


    fun fetchTripeTvShows() {
        viewModelScope.launch {
            val airingTvShows = tvShowsUseCase.airingTodayTvShowsUseCase.execute()
                .onEach {
                    _tvShowMutableStateFlow.value = ResourceState.Loading
                }
            val popularTvShows = tvShowsUseCase.popularTvShowsUseCase.execute()
                .onEach {
                    _tvShowMutableStateFlow.value = ResourceState.Loading
                }
            val onTheAirTvShows = tvShowsUseCase.onTheAirTvShowsUseCase.execute()
                .onEach {
                    _tvShowMutableStateFlow.value = ResourceState.Loading
                }
            combine(airingTvShows, popularTvShows, onTheAirTvShows) { airing, popular, onTheAir ->
                Triple(airing, popular, onTheAir)
            }
                .catch {
                    _tvShowMutableStateFlow.value = ResourceState.Error(it.message)
                }
                .collect {
                    _tvShowMutableStateFlow.value = ResourceState.Success(it)
                }
        }
    }

}