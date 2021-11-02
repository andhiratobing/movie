package com.andhiratobing.movieapp.presentation.fragments.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.andhiratobing.movieapp.R
import com.andhiratobing.movieapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding as FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}