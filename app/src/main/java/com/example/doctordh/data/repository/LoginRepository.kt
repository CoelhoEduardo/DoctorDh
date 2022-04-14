package com.example.doctordh.data.repository

import com.example.doctordh.data.model.LoginRequest
import com.example.doctordh.data.model.LoginResponse
import com.example.doctordh.data.networking.LoginApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LoginRepository(private val loginApi: LoginApi = LoginApi.instance) {
    fun login(email: String, password: String): Flow<LoginResponse> = flow {
        emit(loginApi.getLogin(LoginRequest(email, password)))
    }.flowOn(Dispatchers.IO)

    companion object {
        val instance by lazy { LoginRepository() }
    }


}