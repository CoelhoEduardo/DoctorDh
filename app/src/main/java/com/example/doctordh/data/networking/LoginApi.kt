package com.example.doctordh.data.networking

import com.example.doctordh.data.factory.GsonFactory
import com.example.doctordh.data.factory.OkHttpClientFactory
import com.example.doctordh.data.factory.RetrofityFactory
import com.example.doctordh.data.model.DoctorResponse
import com.example.doctordh.data.model.LoginRequest
import com.example.doctordh.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginApi {

    @POST("login")
    suspend fun getLogin(@Body loginRequest: LoginRequest): LoginResponse

    companion object {
        val instance: LoginApi by lazy {
            RetrofityFactory.build(
                OkHttpClientFactory.build(),
                GsonFactory.build()
            ).create(LoginApi::class.java)
        }
    }

}