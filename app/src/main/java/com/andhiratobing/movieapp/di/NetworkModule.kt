package com.andhiratobing.movieapp.di

import com.andhiratobing.movieapp.data.common.Constants.BASE_URL
import com.andhiratobing.movieapp.data.network.api.ApiService
import com.andhiratobing.movieapp.data.network.data_source.NetworkDataSource
import com.andhiratobing.movieapp.data.network.data_source.NetworkDataSourceImpl
import com.andhiratobing.movieapp.data.repositories.popular_movie.PopularMovieRepositoryImpl
import com.andhiratobing.movieapp.domain.interactor.popular_movie.PopularMovieUseCase
import com.andhiratobing.movieapp.domain.mapper.MovieMapper
import com.andhiratobing.movieapp.domain.repositories.popular_movie.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkDataSource(apiService: ApiService): NetworkDataSource {
        return NetworkDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideMovieMapper(): MovieMapper {
        return MovieMapper()
    }

    @Provides
    @Singleton
    fun provideRepository(networkDataSource: NetworkDataSource, movieMapper: MovieMapper): IMovieRepository {
        return PopularMovieRepositoryImpl(networkDataSource, movieMapper)
    }


    @Provides
    @Singleton
    fun providePopularMovieUseCase(popularIMovieRepository: IMovieRepository): PopularMovieUseCase {
        return PopularMovieUseCase(popularIMovieRepository)
    }

}