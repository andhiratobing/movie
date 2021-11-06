package com.andhiratobing.domain.di

import com.andhiratobing.domain.interactor.MovieUseCase
import com.andhiratobing.domain.interactor.popular_movie.PopularMovieUseCase
import com.andhiratobing.domain.repositories.popular_movie.IPopularMovieRepository
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
    fun providePopularMovieUseCase(iPopularMovieRepository: IPopularMovieRepository) : MovieUseCase {
        return MovieUseCase(
            popularMovieUseCase = PopularMovieUseCase(iPopularMovieRepository)
        )
    }

}