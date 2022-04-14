package com.example.doctordh.data.networking

import com.example.doctordh.data.factory.GsonFactory
import com.example.doctordh.data.factory.OkHttpClientFactory
import com.example.doctordh.data.factory.RetrofityFactory
import com.example.doctordh.data.model.DoctorResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface DoctorApi {

    @GET("doctor")
    suspend fun getDoctors(
        @Query("page") page: Int = 1
    ): DoctorResponse

    companion object {
        val instance: DoctorApi by lazy {
            RetrofityFactory.build(
                OkHttpClientFactory.build(),
                GsonFactory.build()
            ).create(DoctorApi::class.java)
        }
    }
}