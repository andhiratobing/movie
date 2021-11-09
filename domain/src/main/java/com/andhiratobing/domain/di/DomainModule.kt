package com.andhiratobing.domain.di

import com.andhiratobing.domain.interactor.MovieUseCase
import com.andhiratobing.domain.interactor.movie.now_playing_movie.NowPlayingMovieUseCase
import com.andhiratobing.domain.interactor.movie.popular_movie.PopularMovieUseCase
import com.andhiratobing.domain.interactor.movie.up_coming_movie.UpComingMovieUseCase
import com.andhiratobing.domain.repositories.movie.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideMovieUseCase(iMovieRepository: IMovieRepository) : MovieUseCase {
        return MovieUseCase(
            popularMovieUseCase = PopularMovieUseCase(iMovieRepository),
            upComingMovieUseCase = UpComingMovieUseCase(iMovieRepository),
            nowPlayingMovieUseCase = NowPlayingMovieUseCase(iMovieRepository)
        )
    }

}