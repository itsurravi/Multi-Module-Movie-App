package com.ravikantsharma.multi_module_movie.navigation

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.MovieDetailsApi

data class NavigationProvider(
    val movieApi: MovieApi,
    val movieDetailsApi: MovieDetailsApi
)
