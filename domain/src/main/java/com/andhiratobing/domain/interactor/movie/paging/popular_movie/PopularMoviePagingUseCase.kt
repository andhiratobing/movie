package com.andhiratobing.domain.interactor.movie.paging.popular_movie

import androidx.paging.PagingData
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.domain.repositories.movie.paging.IMoviePagingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMoviePagingUseCase @Inject constructor(
    private val iMoviePagingRepository: IMoviePagingRepository
) {

    suspend fun execute(): Flow<PagingData<MovieDomain>> {
        return flow {
            iMoviePagingRepository.getAllPopularMoviePaging()
        }
    }


}