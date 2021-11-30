package com.andhiratobing.movieapp.presentation.fragments.home.movie.paging

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.andhiratobing.domain.common.ResourceState
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentPopularMoviePagingBinding
import com.andhiratobing.movieapp.presentation.utils.extensions.hide
import com.andhiratobing.movieapp.presentation.utils.extensions.show
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class PopularMoviePagingFragment : Fragment(R.layout.fragment_popular_movie_paging) {

    private var _bindingPopularMoviePagingFragment : FragmentPopularMoviePagingBinding? = null
    private val bindingPopularMoviePagingFragment get() = _bindingPopularMoviePagingFragment as FragmentPopularMoviePagingBinding
    private val popularMoviePagingViewModel: PopularMoviePagingViewModel by viewModels()
    @Inject
    lateinit var popularMoviePagingDataAdapter: PopularMoviePagingDataAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindingPopularMoviePagingFragment = FragmentPopularMoviePagingBinding.bind(view)

        setupPopularPagingMovieAdapter()
        collectData()
    }


    private fun collectData() {
        lifecycleScope.launchWhenStarted {
            popularMoviePagingViewModel.popularMoviePaging.collect { result ->
                when(result) {
                    is ResourceState.Loading -> {
                        showProgressBar()
                    }
                    is ResourceState.Success -> {
                        hideProgressBar()
                        popularMoviePagingDataAdapter.submitData(result.data)
                    }
                    is ResourceState.Error -> {
                        hideProgressBar()
                        Snackbar.make(bindingPopularMoviePagingFragment.root, "${result.message}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> Unit
                }

            }
        }
    }

    private fun showProgressBar() {
        bindingPopularMoviePagingFragment.progressBar.itemProgressBar.show()
    }

    private fun hideProgressBar() {
        bindingPopularMoviePagingFragment.progressBar.itemProgressBar.hide()
    }

    private fun setupPopularPagingMovieAdapter() {
        bindingPopularMoviePagingFragment.rvMoviePaging.apply {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = popularMoviePagingDataAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingPopularMoviePagingFragment = null
    }
}