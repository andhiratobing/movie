package com.andhiratobing.repositories.di

import com.andhiratobing.domain.mapper.MovieMapper
import com.andhiratobing.domain.mapper.TvShowsMapper
import com.andhiratobing.domain.mapper.paging.MoviePagingMapper
import com.andhiratobing.domain.repositories.movie.IMovieRepository
import com.andhiratobing.domain.repositories.movie.paging.IMoviePagingRepository
import com.andhiratobing.domain.repositories.tv_shows.ITvShowsRepository
import com.andhiratobing.remote.data_source.NetworkDataSource
import com.andhiratobing.repositories.movie.MovieRepositoryImpl
import com.andhiratobing.repositories.paging.movie.MoviePagingRepositoryImpl
import com.andhiratobing.repositories.tv_shows.TvShowsRepositoryImpl
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

    @Provides
    @Singleton
    fun provideMoviePagingRepository(networkDataSource: NetworkDataSource, moviePagingMapper: MoviePagingMapper): IMoviePagingRepository {
        return MoviePagingRepositoryImpl(networkDataSource, moviePagingMapper)
    }

    @Provides
    @Singleton
    fun provideMoviePagingMapper(): MoviePagingMapper {
        return MoviePagingMapper()
    }

    @Provides
    @Singleton
    fun provideTvShowsRepository(networkDataSource: NetworkDataSource, tvShowsMapper: TvShowsMapper) : ITvShowsRepository {
        return TvShowsRepositoryImpl(networkDataSource, tvShowsMapper)
    }

    @Provides
    @Singleton
    fun provideTvShowsMapper(): TvShowsMapper {
        return TvShowsMapper()
    }
}