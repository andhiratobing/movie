package com.andhiratobing.domain.mapper

import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.remote.dto.MovieDto

class MovieMapper : Mapper<List<MovieDto>, List<MovieDomain>> {

    override fun mapFromEntityToDomain(type: List<MovieDto>): List<MovieDomain> {
        return type.map { movieDto ->
            MovieDomain(
                backdropPath = movieDto.backdropPath,
                genreIds = movieDto.genreIds,
                id = movieDto.id,
                originalTitle = movieDto.originalTitle,
                overview = movieDto.originalTitle,
                posterPath = movieDto.posterPath,
                releaseDate = movieDto.releaseDate,
                voteAverage = movieDto.voteAverage,
            )
        }
    }

    override fun mapFromDomainToEntity(type: List<MovieDomain>): List<MovieDto> {
        return type.map { movieDomain ->
            MovieDto(
                backdropPath = movieDomain.backdropPath,
                genreIds = movieDomain.genreIds,
                id = movieDomain.id,
                originalTitle = movieDomain.originalTitle,
                overview = movieDomain.originalTitle,
                posterPath = movieDomain.posterPath,
                releaseDate = movieDomain.releaseDate,
                voteAverage = movieDomain.voteAverage,
            )
        }
    }


}