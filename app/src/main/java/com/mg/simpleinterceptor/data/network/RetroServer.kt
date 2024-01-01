package com.mg.simpleinterceptor.data.network

import com.mg.simpleinterceptor.utils.TokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroServer {
    private const val base_url = "https://jsonplaceholder.typicode.com/todos/1"
    private fun setInit(): Retrofit {
        val client: OkHttpClient = TokenInterceptor().client
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val instance: ApiService
        get() = setInit().create(ApiService::class.java)
}