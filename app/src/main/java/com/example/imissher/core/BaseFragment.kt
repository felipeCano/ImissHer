package com.example.imissher.core

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment: Fragment() {

    protected fun navController(): NavController? {
        return view?.let { Navigation.findNavController(it) }
    }
}