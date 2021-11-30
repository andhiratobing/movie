package com.andhiratobing.domain.repositories.movie

import com.andhiratobing.domain.models.MovieDomain

interface IMovieRepository {

    suspend fun fetchPopularMovie(): List<MovieDomain>
    suspend fun fetchUpComingMovie(): List<MovieDomain>
    suspend fun fetchNowPlayingMovie(): List<MovieDomain>

}