package com.andhiratobing.domain.mapper

import com.andhiratobing.domain.models.TvShowsDomain
import com.andhiratobing.remote.dto.tv_shows.TvShowsDto

class TvShowsMapper : Mapper<List<TvShowsDto>, List<TvShowsDomain>> {

    override fun mapFromEntityToDomain(type: List<TvShowsDto>): List<TvShowsDomain> {
        return type.map { tvShowsDto ->
            TvShowsDomain(
                backdrop_path = tvShowsDto.backdrop_path,
                first_air_date = tvShowsDto.first_air_date,
                genre_ids = tvShowsDto.genre_ids,
                id = tvShowsDto.id,
                original_name = tvShowsDto.original_name,
                overview = tvShowsDto.overview,
                poster_path = tvShowsDto.poster_path,
                vote_average = tvShowsDto.vote_average
            )
        }
    }

    override fun mapFromDomainToEntity(type: List<TvShowsDomain>): List<TvShowsDto> {
        return type.map { tvShowsDomain ->
            TvShowsDto(
                backdrop_path = tvShowsDomain.backdrop_path,
                first_air_date = tvShowsDomain.first_air_date,
                genre_ids = tvShowsDomain.genre_ids,
                id = tvShowsDomain.id,
                original_name = tvShowsDomain.original_name,
                overview = tvShowsDomain.overview,
                poster_path = tvShowsDomain.poster_path,
                vote_average = tvShowsDomain.vote_average
            )
        }
    }


}