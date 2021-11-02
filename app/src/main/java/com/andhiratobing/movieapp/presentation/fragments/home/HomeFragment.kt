package com.andhiratobing.movieapp.presentation.fragments.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentHomeBinding
import com.andhiratobing.movieapp.domain.common.ResourceState
import com.andhiratobing.movieapp.presentation.fragments.home.adapters.MovieListAdapter
import com.andhiratobing.movieapp.presentation.utils.extensions.hide
import com.andhiratobing.movieapp.presentation.utils.extensions.show
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    @Inject
    lateinit var movieListAdapter: MovieListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        setupAdapter()
        fetchPopularMovie()
        collectData()
    }

    private fun collectData() {
        lifecycleScope.launchWhenStarted {
            homeViewModel.popularMovieStateFlow.collect { result ->
                when(result) {
                    is ResourceState.Loading -> {
                        binding.progressBar.show()
                    }
                    is ResourceState.Success -> {
                        binding.progressBar.hide()
                        movieListAdapter.submitList(result.data)
                    }
                    is ResourceState.Error -> {
                        binding.progressBar.hide()
                        Snackbar.make(binding.root, "${result.message}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun fetchPopularMovie() {
        lifecycleScope.launch {
            homeViewModel.fetchPopularMovie()
        }
    }

    private fun setupAdapter() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = movieListAdapter
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}