package com.andhiratobing.repositories.di

import com.andhiratobing.domain.mapper.MovieMapper
import com.andhiratobing.domain.repositories.popular_movie.IPopularMovieRepository
import com.andhiratobing.remote.data_source.NetworkDataSource
import com.andhiratobing.repositories.popular_movie.PopularMovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(networkDataSource: NetworkDataSource, movieMapper: MovieMapper): IPopularMovieRepository {
        return PopularMovieRepositoryImpl(networkDataSource, movieMapper)
    }

    @Provides
    @Singleton
    fun provideMovieMapper(): MovieMapper {
        return MovieMapper()
    }
}