package com.feature.movie.data.repo

import com.core.network.dataproviders.MovieDataProvider
import com.feature.movie.data.mapper.toDomainMovieList
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repo.MovieRepo
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(
    private val movieDataProviders: MovieDataProvider
) : MovieRepo {

    override suspend fun getMovieList(apiKey: String, q: String): List<Movie> {
        return movieDataProviders.getMovieList(apiKey, q).toDomainMovieList()
    }
}