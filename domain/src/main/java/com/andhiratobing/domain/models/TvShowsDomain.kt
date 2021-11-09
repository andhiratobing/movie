package com.andhiratobing.domain.models

data class TvShowsDomain(
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_name: String,
    val overview: String,
    val poster_path: String,
    val vote_average: Double
)
