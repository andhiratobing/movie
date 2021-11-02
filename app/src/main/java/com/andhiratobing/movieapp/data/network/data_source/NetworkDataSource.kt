package com.andhiratobing.movieapp.data.network.data_source

import com.andhiratobing.movieapp.data.network.dto.MovieDto

interface NetworkDataSource {

    suspend fun fetchPopularMovie(): List<MovieDto>
}