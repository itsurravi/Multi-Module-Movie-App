package com.feature.movie_details.ui.screens.state

import com.feature.movie_details.domain.model.MovieDetails

data class MovieDetailsStateHolder(
    val loading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null
)
