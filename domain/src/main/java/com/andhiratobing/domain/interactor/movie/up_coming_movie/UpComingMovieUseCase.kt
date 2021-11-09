package com.andhiratobing.domain.interactor.movie.up_coming_movie

import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.domain.repositories.movie.IMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpComingMovieUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository
) {

    suspend fun execute(): Flow<List<MovieDomain>> {
        return flow {
            val result = iMovieRepository.fetchUpComingMovie()
            emit(result)
        }
    }

}