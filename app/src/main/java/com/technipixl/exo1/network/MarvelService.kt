package com.technipixl.exo1.network

import com.technipixl.exo1.network.model.MarvelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// 3.
interface MarvelService {
    @GET("public/characters")
    suspend fun getMarvelCharList(
        @Query("ts")
        ts: Long,
        @Query("apikey")
        apiKey: String,
        @Query("hash")
        hash: String?
    ): Response<MarvelResponse>
}