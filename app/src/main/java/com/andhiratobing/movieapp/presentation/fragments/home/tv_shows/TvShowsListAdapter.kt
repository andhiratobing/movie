package com.andhiratobing.movieapp.presentation.fragments.home.tv_shows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.andhiratobing.domain.models.TvShowsDomain
import com.andhiratobing.movieapp.databinding.ItemTvShowsBinding
import javax.inject.Inject

class TvShowsListAdapter @Inject constructor() :
    ListAdapter<TvShowsDomain, TvShowsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        return TvShowsViewHolder(
            ItemTvShowsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowsDomain>() {
            override fun areItemsTheSame(oldItem: TvShowsDomain, newItem: TvShowsDomain): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: TvShowsDomain,
                newItem: TvShowsDomain
            ): Boolean =
                oldItem == newItem

        }
    }
}