package com.andhiratobing.domain.interactor.movie.now_playing_movie

import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.domain.repositories.movie.IMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NowPlayingMovieUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository
) {

    suspend fun execute(): Flow<List<MovieDomain>> {
        return flow {
            val result = iMovieRepository.fetchNowPlayingMovie()
            emit(result)
        }
    }
}