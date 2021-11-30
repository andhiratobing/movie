package com.andhiratobing.movieapp.presentation.fragments.home.movie.detail_movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentDetailMovieBinding

class DetailMovieFragment : Fragment(R.layout.fragment_detail_movie) {

    private var _bindingDetailMovie : FragmentDetailMovieBinding? = null
    private val bindingDetailMovie get() = _bindingDetailMovie

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindingDetailMovie = FragmentDetailMovieBinding.bind(view)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _bindingDetailMovie = null
    }
}