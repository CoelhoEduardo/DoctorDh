package com.example.doctordh.data.model

data class DoctorResponse(val limit_page: Int, val doctors: List<DoctorsData>)
data class DoctorsData(
    val id: String,
    val photo: String,
    val name: String,
    val specialization: String,
    val classification: Double,
    val experience: Int,
    val patientStories: Int,
    val views: Int
)