package com.andhiratobing.domain.models

data class MovieDomain(
    val backdropPath: String?,
    val genreIds: List<Int>?,
    val id: Int?,
    val originalTitle: String?,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val voteAverage: Double?
)
