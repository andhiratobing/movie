package com.andhiratobing.remote.data_source

import com.andhiratobing.remote.dto.MovieDto

interface NetworkDataSource {

    suspend fun fetchPopularMovie(): List<MovieDto>
    suspend fun fetchUpComingMovie(): List<MovieDto>
    suspend fun fetchNowPlayingMovie(): List<MovieDto>
}