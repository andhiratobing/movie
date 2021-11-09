package com.andhiratobing.remote.dto.tv_shows.airing_today_tv_shows

import com.andhiratobing.remote.dto.tv_shows.TvShowsDto
import com.google.gson.annotations.SerializedName

data class AiringTodayTvShowsResponse(
    @SerializedName("results") val results: List<TvShowsDto>
)
