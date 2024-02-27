package com.example.imissher.ui.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.imissher.R
import com.example.imissher.databinding.FragmentMoviesDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.lifecycle.Observer
import coil.load
import coil.size.Scale
import com.example.imissher.model.MovieDetailsResponse
import com.example.imissher.utils.Constants

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMoviesDetailsBinding
    @Inject
    lateinit var movieDetalViewModel : MovieDetailViewModel
    private val args : MoviesDetailsFragmentArgs by navArgs()
    val TAG ="MovieDetailsFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()

    }

    fun initViewDetailSerie(movieDetail: MovieDetailsResponse){
        binding.apply {
            prgBarMovies.visibility = View.INVISIBLE
            val moviePoster = Constants.POSTER_BASE_URL + movieDetail!!.posterPath
            imgMovie.load(moviePoster) {
                crossfade(true)
                placeholder(R.drawable.poster_placeholder)
                scale(Scale.FILL)
            }
            imgMovieBack.load(moviePoster) {
                crossfade(true)
                placeholder(R.drawable.poster_placeholder)
                scale(Scale.FILL)
            }
            tvMovieTitle.text = movieDetail.title
            tvMovieTagLine.text = movieDetail.tagline
            tvMovieDateRelease.text = movieDetail.releaseDate
            tvMovieRating.text = movieDetail.voteAverage.toString()
           tvMovieRuntime.text = movieDetail.runtime.toString()
            tvMovieBudget.text = movieDetail.budget.toString()
            tvMovieRevenue.text = movieDetail.revenue.toString()
            tvMovieOverview.text = movieDetail.overview
        }
    }

    private fun initializeUi() {
        val id=args.movieId
        movieDetalViewModel.getMovies(id)
        movieDetalViewModel.liveDataDetail.observe(viewLifecycleOwner, viewDetails)

    }

    var viewDetails = Observer<MovieDetailsResponse> { movieDetail ->
        initViewDetailSerie(movieDetail)
    }
}