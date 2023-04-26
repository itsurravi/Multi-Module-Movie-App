package com.feature.movie_details.domain.di

import com.feature.movie_details.domain.repository.MovieDetailsRepo
import com.feature.movie_details.domain.use_cases.GetMovieDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun getMovieDetailsUseCase(movieDetailsRepo: MovieDetailsRepo): GetMovieDetailUseCase {
        return GetMovieDetailUseCase(movieDetailsRepo)
    }
}