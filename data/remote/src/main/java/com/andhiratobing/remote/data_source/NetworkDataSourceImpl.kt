package com.andhiratobing.remote.data_source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.andhiratobing.remote.api.ApiService
import com.andhiratobing.remote.data_source.paging.PopularMoviePagingSource
import com.andhiratobing.remote.dto.movie.MovieDto
import com.andhiratobing.remote.dto.tv_shows.TvShowsDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): NetworkDataSource {

    /**
     * Movie
     */

    override suspend fun fetchPopularMovie(): List<MovieDto> {
        return apiService.fetchPopularMovie().result
    }

    override suspend fun fetchUpComingMovie(): List<MovieDto> {
        return apiService.fetchUpComingMovie().result
    }

    override suspend fun fetchNowPlayingMovie(): List<MovieDto> {
        return apiService.fetchNowPlayingMovie().result
    }

    /**
     * Movie Paging
     */
    override suspend fun getAllPopularMoviePaging(): Flow<PagingData<MovieDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                prefetchDistance = 10
            ),
            pagingSourceFactory = { PopularMoviePagingSource(apiService)}
        ).flow
    }

    override suspend fun getAllUpComingMoviePaging(): Flow<PagingData<MovieDto>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllNowPlayingMoviePaging(): Flow<PagingData<MovieDto>> {
        TODO("Not yet implemented")
    }


    /**
     * TV Shows
     */

    override suspend fun fetchAiringTodayTvShows(): List<TvShowsDto> {
        return apiService.fetchAiringTodayTvShows().results
    }

    override suspend fun fetchPopularTvShows(): List<TvShowsDto> {
        return apiService.fetchPopularTvShows().results
    }

    override suspend fun fetchOnTheAirTvShows(): List<TvShowsDto> {
        return apiService.fetchOnTheAirTvShows().results
    }


}