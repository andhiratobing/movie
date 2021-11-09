package com.andhiratobing.domain.repositories.tv_shows

import com.andhiratobing.domain.models.TvShowsDomain

interface ITvShowsRepository {

    suspend fun fetchAiringTodayTvShows(): List<TvShowsDomain>
    suspend fun fetchPopularTvShows(): List<TvShowsDomain>
    suspend fun fetchOnTheAirTvShows(): List<TvShowsDomain>
}