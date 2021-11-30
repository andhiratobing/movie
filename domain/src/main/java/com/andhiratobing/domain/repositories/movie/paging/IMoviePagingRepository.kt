package com.andhiratobing.domain.repositories.movie.paging

import androidx.paging.PagingData
import com.andhiratobing.domain.models.MovieDomain
import kotlinx.coroutines.flow.Flow

interface IMoviePagingRepository {

    suspend fun getAllPopularMoviePaging(): Flow<PagingData<MovieDomain>>
}