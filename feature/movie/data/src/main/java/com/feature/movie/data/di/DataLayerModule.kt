package com.feature.movie.data.di

import com.core.network.dataproviders.MovieDataProvider
import com.feature.movie.data.repo.MovieRepoImpl
import com.feature.movie.domain.repo.MovieRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataLayerModule {

    @Provides
    fun provideMovieRepo(
        movieDataProvider: MovieDataProvider
    ): MovieRepo {
        return MovieRepoImpl(movieDataProvider)
    }
}