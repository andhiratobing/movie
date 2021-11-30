package com.andhiratobing.movieapp.presentation.fragments.home.movie.paging

import androidx.recyclerview.widget.RecyclerView
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.movieapp.databinding.ItemMoviePagingBinding
import com.andhiratobing.remote.common.Constants
import com.bumptech.glide.Glide

class MoviePagingViewHolder(private val binding: ItemMoviePagingBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movieDomain: MovieDomain) {
        binding.apply {
            binding.tvTitleMovie.text = movieDomain.originalTitle

            Glide.with(itemView)
                .load("${Constants.BASE_IMAGE_URL}${movieDomain.posterPath}")
                .centerCrop()
                .into(ivImagePosterPath)
        }
    }
}