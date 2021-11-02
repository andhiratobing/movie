package com.andhiratobing.movieapp.data.network.dto.popular_movie

import com.andhiratobing.movieapp.data.network.dto.MovieDto
import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val result: List<MovieDto>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
