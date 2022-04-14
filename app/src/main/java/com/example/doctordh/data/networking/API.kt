package com.example.doctordh.data.networking

import com.example.doctordh.data.factory.GsonFactory
import com.example.doctordh.data.factory.OkHttpClientFactory
import com.example.doctordh.data.factory.RetrofityFactory
import com.example.doctordh.data.model.ProfileResponse
import retrofit2.http.GET

interface API {

    @GET("api")
    suspend fun getProfile(): ProfileResponse

    companion object{
        val instance: API by lazy {
            RetrofityFactory.build(
                OkHttpClientFactory.build(),
                GsonFactory.build(),
                true
            ).create(API::class.java)
        }
    }
}