package com.andhiratobing.domain.repositories.popular_movie

import com.andhiratobing.domain.models.MovieDomain

interface IPopularMovieRepository {

    suspend fun fetchPopularMovie(): List<MovieDomain>
}