package com.example.doctordh.data.factory

import com.example.doctordh.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofityFactory {
    fun build(client: OkHttpClient, gson: Gson, isRadomApi: Boolean = false): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(if (isRadomApi) BuildConfig.BASE_URL else BuildConfig.BASE_URL2)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

}