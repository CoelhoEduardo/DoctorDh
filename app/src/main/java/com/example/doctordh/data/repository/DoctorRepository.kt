package com.example.doctordh.data.repository

import com.example.doctordh.data.model.DoctorResponse
import com.example.doctordh.data.networking.DoctorApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DoctorRepository(private var doctorApi: DoctorApi = DoctorApi.instance) {
    fun fetchDoctor(page: Int): Flow<DoctorResponse> = flow {
        emit(doctorApi.getDoctors(1))
    }.flowOn(Dispatchers.IO)

    companion object {
        val instances by lazy { DoctorRepository() }
    }
}