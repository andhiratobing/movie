package com.andhiratobing.movieapp.domain.repositories.popular_movie

import com.andhiratobing.movieapp.domain.models.MovieDomain

interface IMovieRepository {

    suspend fun fetchPopularMovie(): List<MovieDomain>
}