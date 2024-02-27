package com.example.imissher.repository

import com.example.imissher.api.ApiServices
import com.example.imissher.model.Movie
import com.example.imissher.model.MovieDetailsResponse
import dagger.hilt.android.scopes.ActivityScoped
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScoped
class ApiRepository @Inject constructor(
    private val apiServices: ApiServices) {
    fun getPopularMoviesList() : Observable<List<Movie>> {
        var reponseApi = apiServices.getPopularMoviesList("9f20bc853860ba666d76c08056986c59","en-US",1)
        return reponseApi.map {
            it.results
        }
    }
    fun getMovieDetails(id: Int): Observable<MovieDetailsResponse> {
        var reponseApi = apiServices.getMovieDetail(id,"9f20bc853860ba666d76c08056986c59")
        return reponseApi
    }
}