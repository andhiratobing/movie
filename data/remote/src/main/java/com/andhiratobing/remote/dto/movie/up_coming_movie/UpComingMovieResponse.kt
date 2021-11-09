package com.andhiratobing.remote.dto.movie.up_coming_movie

import com.andhiratobing.remote.dto.MovieDto
import com.google.gson.annotations.SerializedName

data class UpComingMovieResponse(
    @SerializedName("results") val result: List<MovieDto>
)
