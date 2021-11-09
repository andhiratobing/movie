package com.andhiratobing.domain.interactor.tv_shows.on_the_air_tv_shows

import com.andhiratobing.domain.models.TvShowsDomain
import com.andhiratobing.domain.repositories.tv_shows.ITvShowsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OnTheAirTvShowsUseCase @Inject constructor(
    private val iTvShowsRepository : ITvShowsRepository
) {

    suspend fun execute() : Flow<List<TvShowsDomain>> {
        return flow {
            val result = iTvShowsRepository.fetchOnTheAirTvShows()
            emit(result)
        }
    }
}