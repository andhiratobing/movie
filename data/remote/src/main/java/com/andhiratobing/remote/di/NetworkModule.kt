package com.andhiratobing.remote.di

import com.andhiratobing.remote.api.ApiService
import com.andhiratobing.remote.common.Constants.BASE_URL
import com.andhiratobing.remote.data_source.NetworkDataSource
import com.andhiratobing.remote.data_source.NetworkDataSourceImpl
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
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

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
    fun provideNetworkDataSource(apiService: ApiService): NetworkDataSource {
        return NetworkDataSourceImpl(apiService)
    }


}