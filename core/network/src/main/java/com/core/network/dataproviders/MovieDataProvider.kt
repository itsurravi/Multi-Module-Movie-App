package com.core.network.dataproviders

import com.core.network.ApiService
import javax.inject.Inject

class MovieDataProvider @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovieList(apiKey: String, q: String) = apiService.getMovieList(apiKey, q)

    suspend fun getMovieDetails(id: String, apiKey: String) = apiService.getMovieDetails(id, apiKey)
}