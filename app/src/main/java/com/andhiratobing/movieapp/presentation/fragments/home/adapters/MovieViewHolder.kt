package com.andhiratobing.movieapp.presentation.fragments.home.adapters

import androidx.recyclerview.widget.RecyclerView
import com.andhiratobing.movieapp.data.common.Constants
import com.andhiratobing.movieapp.databinding.ItemMovieBinding
import com.andhiratobing.movieapp.domain.models.MovieDomain
import com.bumptech.glide.Glide

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieDomain) {
        binding.apply {
            binding.tvTitleMovie.text = movie.originalTitle

            Glide.with(itemView)
                .load("${Constants.BASE_IMAGE_URL}${movie.posterPath}")
                .into(ivImagePosterPath)
        }
    }
}