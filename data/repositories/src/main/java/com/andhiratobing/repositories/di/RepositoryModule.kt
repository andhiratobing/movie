package com.andhiratobing.repositories.di

import com.andhiratobing.domain.mapper.MovieMapper
import com.andhiratobing.domain.repositories.movie.IMovieRepository
import com.andhiratobing.remote.data_source.NetworkDataSource
import com.andhiratobing.repositories.movie.MovieRepositoryImpl
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
    fun provideMovieRepository(networkDataSource: NetworkDataSource, movieMapper: MovieMapper): IMovieRepository {
        return MovieRepositoryImpl(networkDataSource, movieMapper)
    }

    @Provides
    @Singleton
    fun provideMovieMapper(): MovieMapper {
        return MovieMapper()
    }
}