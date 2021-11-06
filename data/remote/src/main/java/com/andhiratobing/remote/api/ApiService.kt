package com.andhiratobing.remote.api

import com.andhiratobing.remote.common.Constants.LANGUAGE_API
import com.andhiratobing.remote.common.Constants.MOVIE_API_KEY
import com.andhiratobing.remote.common.Constants.START_PAGE_INDEX
import com.andhiratobing.remote.dto.popular_movie.PopularMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun fetchPopularMovie(
        @Query("api_key") apiKey: String = MOVIE_API_KEY,
        @Query("language") language: String = LANGUAGE_API,
        @Query("page") page: Int = START_PAGE_INDEX
    ): PopularMovieResponse

}