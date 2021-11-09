package com.andhiratobing.movieapp.presentation.fragments.home.tv_shows

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentTvShowsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowsFragment : Fragment(R.layout.fragment_movie) {

    private var _bindingTvShowsFragment : FragmentTvShowsBinding? = null
    private val bindingTvShowsFragment get() = _bindingTvShowsFragment as FragmentTvShowsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindingTvShowsFragment = FragmentTvShowsBinding.bind(view)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _bindingTvShowsFragment = null
    }

}