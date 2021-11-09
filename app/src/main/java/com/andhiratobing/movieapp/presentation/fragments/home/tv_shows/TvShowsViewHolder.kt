package com.andhiratobing.movieapp.presentation.fragments.home.tv_shows

import androidx.recyclerview.widget.RecyclerView
import com.andhiratobing.domain.models.TvShowsDomain
import com.andhiratobing.movieapp.databinding.ItemTvShowsBinding
import com.andhiratobing.remote.common.Constants
import com.bumptech.glide.Glide

class TvShowsViewHolder(private val binding : ItemTvShowsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShowsDomain: TvShowsDomain) {
        binding.apply {
            binding.tvTitleTvShows.text = tvShowsDomain.name

            Glide.with(itemView)
                .load("${Constants.BASE_IMAGE_URL}${tvShowsDomain.posterPath}")
                .centerCrop()
                .into(ivImagePosterPath)
        }
    }
}