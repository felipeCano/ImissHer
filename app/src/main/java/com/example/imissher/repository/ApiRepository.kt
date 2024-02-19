package com.example.imissher.repository

import com.example.imissher.api.ApiServices
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ApiRepository @Inject constructor(
    private val apiServices: ApiServices) {
    fun getPopularMoviesList(apiKey: String,lenguage : String,page: Int) = apiServices.getPopularMoviesList(apiKey,lenguage,page)

    fun getMovieDetails(id: Int) = apiServices.getMovieDetail(id)
}