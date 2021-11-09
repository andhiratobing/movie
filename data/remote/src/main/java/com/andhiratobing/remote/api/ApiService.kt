package com.andhiratobing.remote.api

import com.andhiratobing.remote.common.Constants.LANGUAGE_API
import com.andhiratobing.remote.common.Constants.MOVIE_API_KEY
import com.andhiratobing.remote.common.Constants.START_PAGE_INDEX
import com.andhiratobing.remote.dto.movie.now_playing_movie.NowPlayingMovieResponse
import com.andhiratobing.remote.dto.movie.popular_movie.PopularMovieResponse
import com.andhiratobing.remote.dto.movie.up_coming_movie.UpComingMovieResponse
import com.andhiratobing.remote.dto.tv_shows.popular_tv_shows.PopularTvShowsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun fetchPopularMovie(
        @Query("api_key") apiKey: String = MOVIE_API_KEY,
        @Query("language") language: String = LANGUAGE_API,
        @Query("page") page: Int = START_PAGE_INDEX
    ): PopularMovieResponse

    @GET("movie/upcoming")
    suspend fun fetchUpComingMovie(
        @Query("api_key") apiKey: String = MOVIE_API_KEY,
        @Query("language") language: String = LANGUAGE_API,
        @Query("page") page: Int = START_PAGE_INDEX
    ): UpComingMovieResponse

    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovie(
        @Query("api_key") apiKey: String = MOVIE_API_KEY,
        @Query("language") language: String = LANGUAGE_API,
        @Query("page") page: Int = START_PAGE_INDEX
    ): NowPlayingMovieResponse

    @GET("tv/popular")
    suspend fun fetchPopularTV(
        @Query("api_key") apiKey: String = MOVIE_API_KEY,
        @Query("language") language: String = LANGUAGE_API,
        @Query("page") page: Int = START_PAGE_INDEX
    ): PopularTvShowsResponse

}