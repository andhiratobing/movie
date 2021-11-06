package com.andhiratobing.movieapp.presentation.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.andhiratobing.movieapp.databinding.ItemMovieBinding
import javax.inject.Inject

class MovieListAdapter @Inject constructor() : ListAdapter<com.andhiratobing.domain.models.MovieDomain, MovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object  {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<com.andhiratobing.domain.models.MovieDomain>() {
            override fun areItemsTheSame(oldItem: com.andhiratobing.domain.models.MovieDomain, newItem: com.andhiratobing.domain.models.MovieDomain): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: com.andhiratobing.domain.models.MovieDomain, newItem: com.andhiratobing.domain.models.MovieDomain): Boolean = oldItem == newItem

        }
    }
}

