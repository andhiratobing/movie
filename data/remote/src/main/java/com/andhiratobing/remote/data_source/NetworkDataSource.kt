package com.andhiratobing.remote.data_source

import androidx.paging.PagingData
import com.andhiratobing.remote.dto.movie.MovieDto
import com.andhiratobing.remote.dto.tv_shows.TvShowsDto
import kotlinx.coroutines.flow.Flow

interface NetworkDataSource {

    //movie
    suspend fun fetchPopularMovie(): List<MovieDto>
    suspend fun fetchUpComingMovie(): List<MovieDto>
    suspend fun fetchNowPlayingMovie(): List<MovieDto>

    //movie paging
    suspend fun getAllPopularMoviePaging(): Flow<PagingData<MovieDto>>
    suspend fun getAllUpComingMoviePaging():  Flow<PagingData<MovieDto>>
    suspend fun getAllNowPlayingMoviePaging():  Flow<PagingData<MovieDto>>

    //tv shows
    suspend fun fetchAiringTodayTvShows(): List<TvShowsDto>
    suspend fun fetchPopularTvShows(): List<TvShowsDto>
    suspend fun fetchOnTheAirTvShows(): List<TvShowsDto>


}