package com.andhiratobing.domain.interactor

import com.andhiratobing.domain.interactor.movie.now_playing_movie.NowPlayingMovieUseCase
import com.andhiratobing.domain.interactor.movie.popular_movie.PopularMovieUseCase
import com.andhiratobing.domain.interactor.movie.up_coming_movie.UpComingMovieUseCase

data class MovieUseCase(
    val popularMovieUseCase: PopularMovieUseCase,
    val upComingMovieUseCase: UpComingMovieUseCase,
    val nowPlayingMovieUseCase: NowPlayingMovieUseCase
)
