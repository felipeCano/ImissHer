package com.example.imissher.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import coil.load
import coil.size.Scale
import com.example.imissher.R
import com.example.imissher.databinding.FragmentMoviesDetailsBinding
import com.example.imissher.model.MovieDetailsResponse
import com.example.imissher.repository.ApiRepository
import com.example.imissher.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMoviesDetailsBinding
    @Inject
    lateinit var apiRepository: ApiRepository
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
        val id=args.movieId
        binding.apply {
            prgBarMovies.visibility = View.INVISIBLE
            apiRepository.getMovieDetails(id).enqueue(object : Callback<MovieDetailsResponse>{
                override fun onResponse(
                    call: Call<MovieDetailsResponse>,
                    response: Response<MovieDetailsResponse>
                ) {
                    prgBarMovies.visibility = View.GONE
                    when(response.code()){
                        200->{
                            response.body().let {itBody->
                                val moviePoster = Constants.POSTER_BASE_URL + itBody!!.posterPath
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
                                tvMovieTitle.text = itBody.title
                                tvMovieTagLine.text = itBody.tagline
                                tvMovieDateRelease.text = itBody.releaseDate
                                tvMovieRating.text = itBody.voteAverage.toString()
                                tvMovieRuntime.text = itBody.runtime.toString()
                                tvMovieBudget.text = itBody.budget.toString()
                                tvMovieRevenue.text = itBody.revenue.toString()
                                tvMovieOverview.text = itBody.overview
                            }
                        }
                        401->{
                            Toast.makeText(requireContext(),"The resource you requested could not be found.",
                                Toast.LENGTH_SHORT).show()
                        }
                        404->{
                            Toast.makeText(requireContext(),"Invalide Api",Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<MovieDetailsResponse>, t: Throwable) {
                    prgBarMovies.visibility = View.GONE
                    Toast.makeText(requireContext(),"onFailure",Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}