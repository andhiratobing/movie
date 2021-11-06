package com.andhiratobing.repositories.popular_movie

import com.andhiratobing.domain.mapper.MovieMapper
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.domain.repositories.popular_movie.IPopularMovieRepository
import com.andhiratobing.remote.data_source.NetworkDataSource
import javax.inject.Inject


class PopularMovieRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val mapper: MovieMapper
) : IPopularMovieRepository {

    override suspend fun fetchPopularMovie(): List<MovieDomain> {
        return mapper.mapFromEntityToDomain(networkDataSource.fetchPopularMovie())
    }

}