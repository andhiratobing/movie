package com.andhiratobing.movieapp.data.repositories.popular_movie

import com.andhiratobing.movieapp.data.network.data_source.NetworkDataSource
import com.andhiratobing.movieapp.domain.mapper.MovieMapper
import com.andhiratobing.movieapp.domain.models.MovieDomain
import com.andhiratobing.movieapp.domain.repositories.popular_movie.IMovieRepository
import javax.inject.Inject

class PopularMovieRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val mapper: MovieMapper
) : IMovieRepository {

    override suspend fun fetchPopularMovie(): List<MovieDomain> {
        return mapper.mapFromEntityToDomain(networkDataSource.fetchPopularMovie())
    }

}