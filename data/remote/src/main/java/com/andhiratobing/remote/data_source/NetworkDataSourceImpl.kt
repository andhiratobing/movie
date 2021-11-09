package com.andhiratobing.remote.data_source

import com.andhiratobing.remote.api.ApiService
import com.andhiratobing.remote.dto.movie.MovieDto
import com.andhiratobing.remote.dto.tv_shows.TvShowsDto
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
     * TV Shows
     */

    override suspend fun fetchAiringTodayTvShows(): List<TvShowsDto> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchPopularTvShows(): List<TvShowsDto> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchOnTheAirTvShows(): List<TvShowsDto> {
        TODO("Not yet implemented")
    }


}