package com.andhiratobing.movieapp.presentation.fragments.home.movie.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.movieapp.databinding.ItemMoviePagingBinding
import javax.inject.Inject

class PopularMoviePagingDataAdapter @Inject constructor(): PagingDataAdapter<MovieDomain, MoviePagingViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePagingViewHolder {
        return MoviePagingViewHolder(ItemMoviePagingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MoviePagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieDomain>() {
            override fun areItemsTheSame(oldItem: MovieDomain, newItem: MovieDomain): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieDomain, newItem: MovieDomain): Boolean =
                oldItem == newItem

        }
    }

}