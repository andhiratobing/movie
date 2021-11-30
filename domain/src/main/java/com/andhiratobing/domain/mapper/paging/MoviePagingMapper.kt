package com.andhiratobing.domain.mapper.paging

import androidx.paging.PagingData
import androidx.paging.map
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.remote.dto.movie.MovieDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MoviePagingMapper : MapperPaging<Flow<PagingData<MovieDto>>, Flow<PagingData<MovieDomain>>> {

    override fun mapFromEntityToDomain(type: Flow<PagingData<MovieDto>>): Flow<PagingData<MovieDomain>> {
        return flow {
            type.map {
                it.map { movieDto ->
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
        }
    }

    override fun mapFromDomainToEntity(type: Flow<PagingData<MovieDomain>>): Flow<PagingData<MovieDto>> {
        return flow {
            type.map {
                it.map { movieDomain ->
                    MovieDomain(
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
    }
}
