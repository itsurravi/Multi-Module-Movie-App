package com.feature.movie_details.data.repository

import com.core.network.dataproviders.MovieDataProvider
import com.feature.movie_details.data.mapper.toDomainMovieDetails
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repository.MovieDetailsRepo
import javax.inject.Inject

class MovieDetailsRepoImpl @Inject constructor(
    private val movieDataProvider: MovieDataProvider
) : MovieDetailsRepo {

    override suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails {
        return movieDataProvider.getMovieDetails(id, apiKey).toDomainMovieDetails()
    }
}