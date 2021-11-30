package com.andhiratobing.remote.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.andhiratobing.remote.api.ApiService
import com.andhiratobing.remote.common.Constants.LANGUAGE_API
import com.andhiratobing.remote.common.Constants.MOVIE_API_KEY
import com.andhiratobing.remote.dto.movie.MovieDto
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class PopularMoviePagingSource @Inject constructor(
    private val apiService: ApiService
) : PagingSource<Int, MovieDto>() {

    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        val page = params.key ?: 1

        return try {
            val response = apiService.fetchPopularMovie(MOVIE_API_KEY, LANGUAGE_API, page)
            val result = response.result

            LoadResult.Page(
                data = result,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (result.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }


}