package com.andhiratobing.domain.di

import com.andhiratobing.domain.interactor.movie.MovieUseCase
import com.andhiratobing.domain.interactor.movie.now_playing_movie.NowPlayingMovieUseCase
import com.andhiratobing.domain.interactor.movie.popular_movie.PopularMovieUseCase
import com.andhiratobing.domain.interactor.movie.up_coming_movie.UpComingMovieUseCase
import com.andhiratobing.domain.interactor.tv_shows.TvShowsUseCase
import com.andhiratobing.domain.interactor.tv_shows.airing_today_tv_shows.AiringTodayTvShowsUseCase
import com.andhiratobing.domain.interactor.tv_shows.on_the_air_tv_shows.OnTheAirTvShowsUseCase
import com.andhiratobing.domain.interactor.tv_shows.popular_tv_shows.PopularTvShowsUseCase
import com.andhiratobing.domain.repositories.movie.IMovieRepository
import com.andhiratobing.domain.repositories.tv_shows.ITvShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideMovieUseCase(iMovieRepository: IMovieRepository) : MovieUseCase {
        return MovieUseCase(
            popularMovieUseCase = PopularMovieUseCase(iMovieRepository),
            upComingMovieUseCase = UpComingMovieUseCase(iMovieRepository),
            nowPlayingMovieUseCase = NowPlayingMovieUseCase(iMovieRepository)
        )
    }

    @Provides
    @Singleton
    fun provideTvShowsUseCase(iTvShowsRepository: ITvShowsRepository) : TvShowsUseCase {
        return TvShowsUseCase(
            airingTodayTvShowsUseCase = AiringTodayTvShowsUseCase(iTvShowsRepository),
            popularTvShowsUseCase = PopularTvShowsUseCase(iTvShowsRepository),
            onTheAirTvShowsUseCase = OnTheAirTvShowsUseCase(iTvShowsRepository)
        )
    }

}