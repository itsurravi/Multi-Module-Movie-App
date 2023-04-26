package com.core.network

import com.core.network.model.MovieDetailsDTO
import com.core.network.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("3/search/movie")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("query") q: String
    ): MovieListResponse

    //https://api.themoviedb.org/3/movie/2?api_key=af592cbf9b2096c1450c89c2c5f568a9

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") apiKey: String
    ): MovieDetailsDTO
}