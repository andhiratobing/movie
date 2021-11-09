package com.andhiratobing.domain.interactor.movie.popular_movie

import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.domain.repositories.movie.IMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository
) {

    suspend fun execute(): Flow<List<MovieDomain>> {
        return flow {
            val result = iMovieRepository.fetchPopularMovie()
            emit(result)
        }
    }


}