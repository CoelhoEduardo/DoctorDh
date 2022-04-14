package com.example.doctordh.data.Interceptor

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if(request.url.pathSegments.contains("login")) {
            return chain.proceed(request)
        }

        val newRequest = request
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", Authorization.token?: "")
            .build()

        return chain.proceed(newRequest)
      }
}