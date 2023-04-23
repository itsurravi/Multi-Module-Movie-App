package com.feature.movie.domain.repo

import com.feature.movie.domain.model.Movie

interface MovieRepo {

    suspend fun getMovieList(apiKey:String, q:String): List<Movie>
}