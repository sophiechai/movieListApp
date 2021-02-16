package com.codecademy.movieapp.models

import com.google.gson.annotations.SerializedName

data class IndividualMovie(
    val id: Int,
    val title :String,
    val overview : String,
    @SerializedName("poster_path")
    val poster : String,
    val release_date: String,
    @SerializedName("vote_average")val rating : Int)


