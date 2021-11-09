package com.andhiratobing.movieapp.presentation.fragments.home.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.movieapp.databinding.ItemMovieBinding
import javax.inject.Inject

class MovieListAdapter @Inject constructor() : ListAdapter<MovieDomain, MovieViewHolder>(
    DIFF_CALLBACK
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
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

