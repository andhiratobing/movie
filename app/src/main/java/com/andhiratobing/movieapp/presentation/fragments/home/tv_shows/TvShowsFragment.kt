package com.andhiratobing.movieapp.presentation.fragments.home.tv_shows

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.andhiratobing.domain.common.ResourceState
import com.andhiratobing.domain.models.TvShowsDomain
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentTvShowsBinding
import com.andhiratobing.movieapp.presentation.utils.extensions.hide
import com.andhiratobing.movieapp.presentation.utils.extensions.show
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {

    private var _bindingTvShowsFragment: FragmentTvShowsBinding? = null
    private val bindingTvShowsFragment get() = _bindingTvShowsFragment as FragmentTvShowsBinding
    private val tvShowsViewModel: TvShowsViewModel by viewModels()
    @Inject
    lateinit var airingTvShowListAdapter: TvShowsListAdapter
    @Inject
    lateinit var popularTvShowListAdapter: TvShowsListAdapter
    @Inject
    lateinit var onTheAirTvShowListAdapter: TvShowsListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindingTvShowsFragment = FragmentTvShowsBinding.bind(view)

        collectData()
        fetchPopularTvShows()
        setupAiringTvShowAdapter()
        setupPopularTvShowAdapter()
        setupOnTheAirTvShowAdapter()
    }

    private fun collectData() {
        lifecycleScope.launchWhenStarted {
            tvShowsViewModel.tvShowStateFlow.collect { result ->
                when (result) {
                    is ResourceState.Loading -> {
                        showProgressBar()
                        hideTitleMovie()
                    }
                    is ResourceState.Success -> {
                        hideProgressBar()
                        submitTripleData(result.data)
                        showTitleMovie()
                    }
                    is ResourceState.Error -> {
                        hideProgressBar()
                        hideTitleMovie()
                        Snackbar.make(bindingTvShowsFragment.root, "${result.message}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun submitTripleData(data: Triple<List<TvShowsDomain>, List<TvShowsDomain>, List<TvShowsDomain>>) {
        airingTvShowListAdapter.submitList(data.first)
        popularTvShowListAdapter.submitList(data.second)
        onTheAirTvShowListAdapter.submitList(data.third)
    }

    private fun showTitleMovie() {
        bindingTvShowsFragment.rvTripeTvShowsList.tvTitleAiringTvShows.show()
        bindingTvShowsFragment.rvTripeTvShowsList.tvSeeAllAiringTvShows.show()
        bindingTvShowsFragment.rvTripeTvShowsList.tvTitlePopularTvShows.show()
        bindingTvShowsFragment.rvTripeTvShowsList.tvSeeAllPopularTvShows.show()
        bindingTvShowsFragment.rvTripeTvShowsList.tvTitleOnTheAirTvShows.show()
        bindingTvShowsFragment.rvTripeTvShowsList.tvSeeAllOnTheAirTvShows.show()

    }

    private fun hideTitleMovie() {
        bindingTvShowsFragment.rvTripeTvShowsList.tvTitleAiringTvShows.hide()
        bindingTvShowsFragment.rvTripeTvShowsList.tvSeeAllAiringTvShows.hide()
        bindingTvShowsFragment.rvTripeTvShowsList.tvTitlePopularTvShows.hide()
        bindingTvShowsFragment.rvTripeTvShowsList.tvSeeAllPopularTvShows.hide()
        bindingTvShowsFragment.rvTripeTvShowsList.tvTitleOnTheAirTvShows.hide()
        bindingTvShowsFragment.rvTripeTvShowsList.tvSeeAllOnTheAirTvShows.hide()
    }

    private fun showProgressBar() {
        bindingTvShowsFragment.progressBar.itemProgressBar.show()
    }

    private fun hideProgressBar() {
        bindingTvShowsFragment.progressBar.itemProgressBar.hide()
    }


    private fun fetchPopularTvShows() {
        lifecycleScope.launch {
            tvShowsViewModel.fetchTripeTvShows()
        }
    }

    private fun setupAiringTvShowAdapter() {
        bindingTvShowsFragment.rvTripeTvShowsList.rvAiringTvShows.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = airingTvShowListAdapter
        }
    }

    private fun setupPopularTvShowAdapter() {
        bindingTvShowsFragment.rvTripeTvShowsList.rvPopularTvShows.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = popularTvShowListAdapter
        }
    }

    private fun setupOnTheAirTvShowAdapter() {
        bindingTvShowsFragment.rvTripeTvShowsList.rvOnTheAirTvShows.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = onTheAirTvShowListAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _bindingTvShowsFragment = null
    }

}