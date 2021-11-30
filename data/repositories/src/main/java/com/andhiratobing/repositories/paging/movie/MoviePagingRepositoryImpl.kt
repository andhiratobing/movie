package com.andhiratobing.repositories.paging.movie

import androidx.paging.PagingData
import com.andhiratobing.domain.mapper.paging.MoviePagingMapper
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.domain.repositories.movie.paging.IMoviePagingRepository
import com.andhiratobing.remote.data_source.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviePagingRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val moviePagingMapper: MoviePagingMapper
) : IMoviePagingRepository{

    override suspend fun getAllPopularMoviePaging(): Flow<PagingData<MovieDomain>> {
        return moviePagingMapper.mapFromEntityToDomain(networkDataSource.getAllPopularMoviePaging())
    }
}