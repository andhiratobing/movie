package com.andhiratobing.remote.dto.tv_shows.popular_tv_shows

import com.andhiratobing.remote.dto.tv_shows.TvShowsDto
import com.google.gson.annotations.SerializedName

data class PopularTvShowsResponse(
    @SerializedName("results") val results: List<TvShowsDto>
)
