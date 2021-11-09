package com.andhiratobing.repositories.tv_shows

import com.andhiratobing.domain.mapper.TvShowsMapper
import com.andhiratobing.domain.models.TvShowsDomain
import com.andhiratobing.domain.repositories.tv_shows.ITvShowsRepository
import com.andhiratobing.remote.data_source.NetworkDataSource
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val tvShowsMapper: TvShowsMapper
) : ITvShowsRepository{

    override suspend fun fetchAiringTodayTvShows(): List<TvShowsDomain> {
        return tvShowsMapper.mapFromEntityToDomain(networkDataSource.fetchAiringTodayTvShows())
    }

    override suspend fun fetchPopularTvShows(): List<TvShowsDomain> {
        return tvShowsMapper.mapFromEntityToDomain(networkDataSource.fetchPopularTvShows())
    }

    override suspend fun fetchOnTheAirTvShows(): List<TvShowsDomain> {
        return tvShowsMapper.mapFromEntityToDomain(networkDataSource.fetchOnTheAirTvShows())
    }


}