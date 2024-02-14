package com.example.imissher.api

import com.example.imissher.model.MovieDetailsResponse
import com.example.imissher.model.MoviesListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @GET("popular")
    fun getPopularMoviesList(@Query("pages") page : Int) : Call<MoviesListResponse>

    @GET("{movie_id}")
    fun getMovieDetail(@Path("movie_id") movie_Id : Int) : Call<MovieDetailsResponse>
}