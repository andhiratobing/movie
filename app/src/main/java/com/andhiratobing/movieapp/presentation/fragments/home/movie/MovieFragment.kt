package com.andhiratobing.movieapp.presentation.fragments.home.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andhiratobing.domain.common.ResourceState
import com.andhiratobing.domain.models.MovieDomain
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentMovieBinding
import com.andhiratobing.movieapp.presentation.utils.extensions.hide
import com.andhiratobing.movieapp.presentation.utils.extensions.show
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private var _bindingMovieFragment : FragmentMovieBinding? = null
    private val bindingMovieFragment get() = _bindingMovieFragment as FragmentMovieBinding

    private val movieViewModel: MovieViewModel by viewModels()
    @Inject
    lateinit var popularMovieListAdapter: MovieListAdapter
    @Inject
    lateinit var upComingMovieListAdapter: MovieListAdapter
    @Inject
    lateinit var nowPlayingMovieListAdapter: MovieListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindingMovieFragment = FragmentMovieBinding.bind(view)

        setupPopularMovieAdapter()
        setupNowPlayingMovieAdapter()
        setupUpComingMovieAdapter()
        fetchPopularMovie()
        collectData()
        seeAllPopularMovie()
    }

    private fun collectData() {
        lifecycleScope.launchWhenStarted {
            movieViewModel.movieStateFlow.collect { result ->
                when(result) {
                    is ResourceState.Loading -> {
                        showProgressBar()
                        hideTitleMovie()
                    }
                    is ResourceState.Success<Triple<List<MovieDomain>, List<MovieDomain>, List<MovieDomain>>> -> {
                        hideProgressBar()
                        showTitleMovie()
                        submitTripleData(result.data)
                    }
                    is ResourceState.Error -> {
                        hideProgressBar()
                        hideTitleMovie()
                        Snackbar.make(bindingMovieFragment.root, "${result.message}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun seeAllPopularMovie(){
        bindingMovieFragment.apply {
            rvTripeMovieList.tvSeeAllPopularMovie.setOnClickListener {
                goToPopularMoviePaging()
            }
        }
    }

    private fun goToPopularMoviePaging() {
        if (findNavController().currentDestination?.id == R.id.movieFragment) {
            val directions = MovieFragmentDirections.actionMovieFragmentToPopularMoviePagingFragment()
            findNavController().navigate(directions)
        } else {
            return
        }
    }

    private fun submitTripleData(data: Triple<List<MovieDomain>, List<MovieDomain>, List<MovieDomain>>) {
        popularMovieListAdapter.submitList(data.first)
        upComingMovieListAdapter.submitList(data.second)
        nowPlayingMovieListAdapter.submitList(data.third)
    }

    private fun showTitleMovie() {
        bindingMovieFragment.rvTripeMovieList.tvTitlePopularMovie.show()
        bindingMovieFragment.rvTripeMovieList.tvSeeAllPopularMovie.show()
        bindingMovieFragment.rvTripeMovieList.tvTitleUpComingMovie.show()
        bindingMovieFragment.rvTripeMovieList.tvSeeAllUpComingMovie.show()
        bindingMovieFragment.rvTripeMovieList.tvTitleNowPlayingMovie.show()
        bindingMovieFragment.rvTripeMovieList.tvSeeAllNowPlayingMovie.show()

    }

    private fun hideTitleMovie() {
        bindingMovieFragment.rvTripeMovieList.tvTitlePopularMovie.hide()
        bindingMovieFragment.rvTripeMovieList.tvSeeAllPopularMovie.hide()
        bindingMovieFragment.rvTripeMovieList.tvTitleUpComingMovie.hide()
        bindingMovieFragment.rvTripeMovieList.tvSeeAllUpComingMovie.hide()
        bindingMovieFragment.rvTripeMovieList.tvTitleNowPlayingMovie.hide()
        bindingMovieFragment.rvTripeMovieList.tvSeeAllNowPlayingMovie.hide()
    }

    private fun showProgressBar() {
        bindingMovieFragment.progressBar.itemProgressBar.show()
    }

    private fun hideProgressBar() {
        bindingMovieFragment.progressBar.itemProgressBar.hide()
    }


    private fun fetchPopularMovie() {
        lifecycleScope.launch {
            movieViewModel.fetchTripleMovie()
        }
    }

    private fun setupPopularMovieAdapter() {
        bindingMovieFragment.rvTripeMovieList.rvPopularMovie.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = popularMovieListAdapter
        }
    }

    private fun setupUpComingMovieAdapter() {
        bindingMovieFragment.rvTripeMovieList.rvUpComingMovie.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = upComingMovieListAdapter
        }
    }

    private fun setupNowPlayingMovieAdapter() {
        bindingMovieFragment.rvTripeMovieList.rvNowPlayingMovie.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = nowPlayingMovieListAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _bindingMovieFragment = null
    }

}