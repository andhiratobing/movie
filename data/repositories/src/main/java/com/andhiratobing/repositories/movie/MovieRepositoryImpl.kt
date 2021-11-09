package com.andhiratobing.repositories.movie

import com.andhiratobing.domain.mapper.MovieMapper
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.domain.repositories.movie.IMovieRepository
import com.andhiratobing.remote.data_source.NetworkDataSource
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val movieMapper: MovieMapper
) : IMovieRepository {

    override suspend fun fetchPopularMovie(): List<MovieDomain> {
        return movieMapper.mapFromEntityToDomain(networkDataSource.fetchPopularMovie())
    }

    override suspend fun fetchUpComingMovie(): List<MovieDomain> {
        return movieMapper.mapFromEntityToDomain(networkDataSource.fetchUpComingMovie())
    }

    override suspend fun fetchNowPlayingMovie(): List<MovieDomain> {
        return movieMapper.mapFromEntityToDomain(networkDataSource.fetchNowPlayingMovie())
    }

}