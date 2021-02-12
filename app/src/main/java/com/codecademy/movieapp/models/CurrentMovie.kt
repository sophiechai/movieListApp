package com.codecademy.movieapp.models

data class CurrentMovie(
    var page: Int,
    var results: ArrayList<IndividualMovie>,
    var total_pages: Int,
    var total_results: Int)
