package com.example.imissher.ui.view.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.imissher.ui.adapter.MoviesAdapter
import com.example.imissher.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.example.imissher.R
import com.example.imissher.core.BaseFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imissher.model.Movie
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class MoviesFragment : BaseFragment(){

    @Inject
    lateinit var moviesAdapter: MoviesAdapter
    @Inject
    lateinit var movieViewModel: MoviesViewModel
    var mAdapter: RecyclerView ? = null
    var mProgressBar: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = view.findViewById(R.id.rlMovies)
        mProgressBar = view.findViewById(R.id.prgBarMovies)
        initializeUi()
    }
    private fun initializeUi() {
        movieViewModel.getMovies()
        movieViewModel.liveData.observe(viewLifecycleOwner, recyclerPopular)
    }

    fun initAdapterPopular(movie: List<Movie>) {
        mProgressBar!!.visibility = View.GONE
        Log.d("moviesOnFragment", movie.toString())
        moviesAdapter.differ.submitList(movie)
        mAdapter?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this!!.adapter = moviesAdapter
        }
        moviesAdapter.setOnItemClickListener {
            val direction = MoviesFragmentDirections.actionMoviesFragmentToMoviesDetailsFragment(it.id)
            findNavController().navigate(direction)
        }
    }

    var recyclerPopular = Observer<List<Movie>> { movie ->
        Log.d("moviesOnFragment", movie.toString())
        initAdapterPopular(movie)
    }
}