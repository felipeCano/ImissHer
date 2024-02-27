package com.example.imissher.api


import com.example.imissher.model.Movie
import com.example.imissher.model.MovieDetailsResponse
import com.example.imissher.model.MoviesListResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
const val API_KEY = "9f20bc853860ba666d76c08056986c59"
const val ACCEPT_TOKEN: String = "accept: application/json"
const val CONTENT_TYPE: String = "Authorization" + "Bearer 9f20bc853860ba666d76c08056986c59"
interface ApiServices {

   // @Headers(ACCEPT_TOKEN, CONTENT_TYPE)
    @GET("popular")
    fun getPopularMoviesList(  @Query("api_key") apiKey: String = API_KEY,
                               @Query("language") language: String = "en-US",
                               @Query("pages") page : Int
    ): Observable<MoviesListResponse>

    @GET("{movie_id}")
    fun getMovieDetail(@Path("movie_id") movie_Id : Int,@Query("api_key") apiKey: String = API_KEY) : Observable<MovieDetailsResponse>
}