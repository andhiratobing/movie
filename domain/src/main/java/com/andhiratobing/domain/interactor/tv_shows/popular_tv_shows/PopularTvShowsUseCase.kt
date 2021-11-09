package com.andhiratobing.domain.interactor.tv_shows.popular_tv_shows

import com.andhiratobing.domain.models.TvShowsDomain
import com.andhiratobing.domain.repositories.tv_shows.ITvShowsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularTvShowsUseCase @Inject constructor(
    private val iTvShowsRepository: ITvShowsRepository
){

    suspend fun execute() : Flow<List<TvShowsDomain>> {
        return flow {
            val result = iTvShowsRepository.fetchPopularTvShows()
            emit(result)
        }
    }
}