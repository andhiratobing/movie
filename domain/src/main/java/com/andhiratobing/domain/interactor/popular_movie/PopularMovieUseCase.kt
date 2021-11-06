package com.andhiratobing.domain.interactor.popular_movie

import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.domain.repositories.popular_movie.IPopularMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val popularMovieRepository: IPopularMovieRepository
) {

    suspend fun execute(): Flow<List<MovieDomain>> {
        return flow {
            val result = popularMovieRepository.fetchPopularMovie()
            emit(result)
        }
    }


}