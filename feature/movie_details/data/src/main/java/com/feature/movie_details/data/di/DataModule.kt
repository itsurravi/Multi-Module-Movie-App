package com.feature.movie_details.data.di

import com.core.network.dataproviders.MovieDataProvider
import com.feature.movie_details.data.repository.MovieDetailsRepoImpl
import com.feature.movie_details.domain.repository.MovieDetailsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideMovieDetailsRepo(movieDataProvider: MovieDataProvider): MovieDetailsRepo {
        return MovieDetailsRepoImpl(movieDataProvider)
    }
}