package com.andhiratobing.remote.dto.tv_shows.on_the_air_tv_shows

import com.andhiratobing.remote.dto.tv_shows.TvShowsDto
import com.google.gson.annotations.SerializedName

data class OnTheAirTvShowsResponse(
    @SerializedName("results") val results: List<TvShowsDto>
)
