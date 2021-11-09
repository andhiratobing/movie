package com.andhiratobing.remote.data_source

import com.andhiratobing.remote.dto.movie.MovieDto
import com.andhiratobing.remote.dto.tv_shows.TvShowsDto

interface NetworkDataSource {

    //movie
    suspend fun fetchPopularMovie(): List<MovieDto>
    suspend fun fetchUpComingMovie(): List<MovieDto>
    suspend fun fetchNowPlayingMovie(): List<MovieDto>


    //tv shows
    suspend fun fetchAiringTodayTvShows(): List<TvShowsDto>
    suspend fun fetchPopularTvShows(): List<TvShowsDto>
    suspend fun fetchOnTheAirTvShows(): List<TvShowsDto>
}