package com.feature.movie.data.mapper

import com.core.network.model.MovieListResponse
import com.feature.movie.domain.model.Movie

fun MovieListResponse.toDomainMovieList(): List<Movie> {
    return this.results.map {
        Movie(id = it.id.toString(), imageUrl = makeFullUrl(it.posterPath))
    }
}

fun makeFullUrl(path: String?) = "https://image.tmdb.org/t/p/w500$path"