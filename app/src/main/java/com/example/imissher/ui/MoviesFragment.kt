package com.example.imissher.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.imissher.adapter.MoviesAdapter
import com.example.imissher.databinding.FragmentMoviesBinding
import com.example.imissher.model.MoviesListResponse
import com.example.imissher.repository.ApiRepository
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import retrofit2.Callback

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    @Inject
    lateinit var apiRepository: ApiRepository
    @Inject
    lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            prgBarMovies.visibility = View.GONE
            apiRepository.getPopularMoviesList("9f20bc853860ba666d76c08056986c59","en-US",1).enqueue(object : Callback<MoviesListResponse> {
                override fun onResponse(
                    call: Call<MoviesListResponse>,
                    response: Response<MoviesListResponse>
                ) {
                   when(response.code()){
                       200->{
                           response.body().let {itBody->
                                if (itBody?.results!!.isNotEmpty()){
                                    moviesAdapter.differ.submitList(itBody.results)
                                }
                               rlMovies.apply {
                                   layoutManager = LinearLayoutManager(requireContext())
                                   adapter = moviesAdapter
                               }
                           }
                       }
                       400->{
                           Toast.makeText(requireContext(),"The resource you requested could not be found.",Toast.LENGTH_SHORT).show()
                       }
                       401->{
                           Toast.makeText(requireContext(),"Invalide Api",Toast.LENGTH_SHORT).show()
                       }
                   }
                }

                override fun onFailure(call: Call<MoviesListResponse>, t: Throwable) {
                    prgBarMovies.visibility = View.GONE
                    Toast.makeText(requireContext(),"onFailure",Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}