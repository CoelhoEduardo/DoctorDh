package com.example.doctordh.data.repository

import com.example.doctordh.data.model.ProfileResponse
import com.example.doctordh.data.networking.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class UserRepository(
    private val api: API = API.instance
) {
    fun fetchProfile(): Flow<ProfileResponse> = flow {
            emit(api.getProfile())
    }.flowOn(Dispatchers.IO)

    companion object {
        val instances by lazy { UserRepository() }
    }
}
