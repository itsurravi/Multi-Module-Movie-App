package com.feature.movie.ui.screen.state

import com.feature.movie.domain.model.Movie

data class MovieSearchStateHolder(
    val loading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = ""
)
