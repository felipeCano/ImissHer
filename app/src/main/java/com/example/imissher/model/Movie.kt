package com.example.imissher.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("backdrop_path")
    val backdropPath: String, // /wcKFYIiVDvRURrzglV9kGu7fpfY.jpg
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int, // 453395
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_title")
    val originalTitle: String, // Doctor Strange in the Multiverse of Madness
    @SerializedName("overview")
    val overview: String, // Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.
    @SerializedName("popularity")
    val popularity: Double, // 7931.499
    @SerializedName("poster_path")
    val posterPath: String, // /9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg
    @SerializedName("release_date")
    val releaseDate: String, // 2022-05-04
    @SerializedName("title")
    val title: String, // Doctor Strange in the Multiverse of Madness
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Double, // 7.5
    @SerializedName("vote_count")
    val voteCount: Int // 3987
)