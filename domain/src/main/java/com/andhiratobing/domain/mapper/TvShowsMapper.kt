package com.andhiratobing.domain.mapper

import com.andhiratobing.domain.models.TvShowsDomain
import com.andhiratobing.remote.dto.tv_shows.TvShowsDto

class TvShowsMapper : Mapper<List<TvShowsDto>, List<TvShowsDomain>> {

    override fun mapFromEntityToDomain(type: List<TvShowsDto>): List<TvShowsDomain> {
        return type.map { tvShowsDto ->
            TvShowsDomain(
                backdropPath = tvShowsDto.backdropPath,
                firstAirDate = tvShowsDto.firstAirDate,
                genreIds = tvShowsDto.genreIds,
                id = tvShowsDto.id,
                name = tvShowsDto.name,
                overview = tvShowsDto.overview,
                posterPath = tvShowsDto.posterPath,
                voteAverage = tvShowsDto.voteAverage
            )
        }
    }

    override fun mapFromDomainToEntity(type: List<TvShowsDomain>): List<TvShowsDto> {
        return type.map { tvShowsDomain ->
            TvShowsDto(
                backdropPath = tvShowsDomain.backdropPath,
                firstAirDate = tvShowsDomain.firstAirDate,
                genreIds = tvShowsDomain.genreIds,
                id = tvShowsDomain.id,
                name = tvShowsDomain.name,
                overview = tvShowsDomain.overview,
                posterPath = tvShowsDomain.posterPath,
                voteAverage = tvShowsDomain.voteAverage
            )
        }
    }


}