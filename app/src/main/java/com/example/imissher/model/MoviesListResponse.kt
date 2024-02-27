package com.example.imissher.model

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Movie> = emptyList(),
    @SerializedName("total_pages")
    val totalPages: Int, // 34218
    @SerializedName("total_results")
    val totalResults: Int // 684341
) {
}