package com.andhiratobing.domain.models

data class TvShowsDomain(
    val backdropPath: String?,
    val firstAirDate: String?,
    val genreIds: List<Int>?,
    val id: Int?,
    val name: String?,
    val overview: String?,
    val posterPath: String?,
    val voteAverage: Double?
)
