package com.andhiratobing.remote.dto.movie.now_playing_movie

import com.andhiratobing.remote.dto.movie.MovieDto
import com.google.gson.annotations.SerializedName

data class NowPlayingMovieResponse(
    @SerializedName("results") val result: List<MovieDto>
)
