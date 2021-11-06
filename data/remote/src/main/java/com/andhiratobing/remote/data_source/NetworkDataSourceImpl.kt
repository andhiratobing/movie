package com.andhiratobing.remote.data_source

import com.andhiratobing.remote.api.ApiService
import com.andhiratobing.remote.dto.MovieDto
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): NetworkDataSource {

    override suspend fun fetchPopularMovie(): List<MovieDto> {
        return apiService.fetchPopularMovie().result
    }


}