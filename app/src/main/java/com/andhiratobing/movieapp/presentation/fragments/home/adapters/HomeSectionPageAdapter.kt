package com.andhiratobing.movieapp.presentation.fragments.home.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.andhiratobing.movieapp.presentation.fragments.home.movie.MovieFragment
import com.andhiratobing.movieapp.presentation.fragments.home.tv_shows.TvShowsFragment

class HomeSectionPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvShowsFragment()
            else -> Unit
        }
        return fragment
    }
}