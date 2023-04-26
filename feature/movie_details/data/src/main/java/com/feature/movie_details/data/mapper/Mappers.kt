package com.feature.movie_details.data.mapper

import com.core.network.model.MovieDetailsDTO
import com.feature.movie_details.domain.model.MovieDetails

fun MovieDetailsDTO.toDomainMovieDetails(): MovieDetails {
    return MovieDetails(
        title = this.originalTitle,
        description = this.overview,
        imageUrl = makeFullUrl(this.posterPath)
    )
}

fun makeFullUrl(path: String?) = "https://image.tmdb.org/t/p/w500$path"