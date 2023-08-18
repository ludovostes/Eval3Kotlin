package com.technipixl.exo1.network

import com.technipixl.exo1.network.model.MarvelResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MarvelImpl {
    // 5.1
    fun getRetrofit(): Retrofit {
        val okBuilder = OkHttpClient().newBuilder().apply {
            connectTimeout(15, TimeUnit.SECONDS)
            callTimeout(15, TimeUnit.SECONDS)
            readTimeout(15, TimeUnit.SECONDS)
            writeTimeout(15, TimeUnit.SECONDS)
        }
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build())
            .build()
    }

    // 5.2
    suspend fun getMarvelChar(ts: Long, apiKey: String, hash: String?): Response<MarvelResponse> {
        return getRetrofit().create(MarvelService::class.java).getMarvelCharList(ts= ts, apiKey= apiKey, hash= hash)
    }
}