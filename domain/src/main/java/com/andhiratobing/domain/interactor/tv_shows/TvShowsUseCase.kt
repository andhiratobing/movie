package com.andhiratobing.domain.interactor.tv_shows

import com.andhiratobing.domain.interactor.tv_shows.airing_today_tv_shows.AiringTodayTvShowsUseCase
import com.andhiratobing.domain.interactor.tv_shows.on_the_air_tv_shows.OnTheAirTvShowsUseCase
import com.andhiratobing.domain.interactor.tv_shows.popular_tv_shows.PopularTvShowsUseCase

data class TvShowsUseCase(
    val airingTodayTvShowsUseCase: AiringTodayTvShowsUseCase,
    val onTheAirTvShowsUseCase: OnTheAirTvShowsUseCase,
    val popularTvShowsUseCase: PopularTvShowsUseCase
)
