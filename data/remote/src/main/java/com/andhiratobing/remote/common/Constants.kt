package com.andhiratobing.remote.common

import com.andhiratobing.remote.BuildConfig


object Constants {

    private const val API_VERSION = 3
    const val BASE_URL = "https://api.themoviedb.org/$API_VERSION/"
    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    const val MOVIE_API_KEY = BuildConfig.MOVIE_API
    const val LANGUAGE_API = "en-US"
    const val START_PAGE_INDEX = 1
}