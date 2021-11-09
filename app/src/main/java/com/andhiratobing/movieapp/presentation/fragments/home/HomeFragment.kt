package com.andhiratobing.movieapp.presentation.fragments.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentHomeBinding
import com.andhiratobing.movieapp.presentation.fragments.home.adapters.HomeSectionPageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _bindingHomeFragment: FragmentHomeBinding? = null
    private val bindingHomeFragment get() = _bindingHomeFragment as FragmentHomeBinding
    private lateinit var homeSectionPageAdapter: HomeSectionPageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bindingHomeFragment = FragmentHomeBinding.bind(view)

        setTabLayoutAdapter()
    }

    private fun setTabLayoutAdapter() {
        bindingHomeFragment.apply {
            homeSectionPageAdapter = HomeSectionPageAdapter(parentFragmentManager, lifecycle)
            viewPager.adapter = homeSectionPageAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when(position) {
                    0 -> tab.text = resources.getString(R.string.tab_movie)
                    1 -> tab.text = resources.getString(R.string.tab_tv_shows)
                }
            }.attach()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _bindingHomeFragment = null
    }
}