package com.andhiratobing.remote.dto.movie.popular_movie

import com.andhiratobing.remote.dto.MovieDto
import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("results") val result: List<MovieDto>
)
