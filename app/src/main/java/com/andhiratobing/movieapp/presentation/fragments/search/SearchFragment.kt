package com.andhiratobing.movieapp.presentation.fragments.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding as FragmentSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}