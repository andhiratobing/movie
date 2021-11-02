package com.andhiratobing.movieapp.data.network.data_source

import com.andhiratobing.movieapp.data.network.api.ApiService
import com.andhiratobing.movieapp.data.network.dto.MovieDto
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): NetworkDataSource {

    override suspend fun fetchPopularMovie(): List<MovieDto> {
        return apiService.fetchPopularMovie().result
    }


}