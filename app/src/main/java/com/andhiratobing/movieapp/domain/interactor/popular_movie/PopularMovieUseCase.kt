package com.andhiratobing.movieapp.domain.interactor.popular_movie

import com.andhiratobing.movieapp.domain.models.MovieDomain
import com.andhiratobing.movieapp.domain.repositories.popular_movie.IMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val popularMovieRepository: IMovieRepository
) {

    suspend fun execute(): Flow<List<MovieDomain>> {
        return flow {
            val result = popularMovieRepository.fetchPopularMovie()
            emit(result)
        }
    }


}