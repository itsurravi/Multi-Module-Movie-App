package com.feature.movie.domain.di

import com.feature.movie.domain.repo.MovieRepo
import com.feature.movie.domain.use_cases.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {

    @Provides
    fun provideGetMovieListUseCase(
        movieRepo: MovieRepo
    ): GetMovieListUseCase {
        return GetMovieListUseCase(movieRepo)
    }
}