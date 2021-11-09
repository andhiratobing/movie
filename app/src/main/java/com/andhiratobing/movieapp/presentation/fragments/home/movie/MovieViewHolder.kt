package com.andhiratobing.movieapp.presentation.fragments.home.movie

import androidx.recyclerview.widget.RecyclerView
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.movieapp.databinding.ItemMovieBinding
import com.andhiratobing.remote.common.Constants.BASE_IMAGE_URL
import com.bumptech.glide.Glide

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieDomain) {
        binding.apply {
            binding.tvTitleMovie.text = movie.originalTitle

            Glide.with(itemView)
                .load("${BASE_IMAGE_URL}${movie.posterPath}")
                .centerCrop()
                .into(ivImagePosterPath)
        }
    }
}