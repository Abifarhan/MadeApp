package com.abifarhan.madeapp.core.data.source.remote.network

import com.abifarhan.madeapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/tv?")
    suspend fun getList(@Query("api_key") key: String): ListMovieResponse
}