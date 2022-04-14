package com.example.doctordh.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doctordh.data.model.DoctorResponse
import com.example.doctordh.data.repository.DoctorRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DoctorViewModel (private val doctorRepository: DoctorRepository = DoctorRepository.instances): ViewModel() {

    var limitPages = 0

    private val _doctors = MutableLiveData<DoctorResponse>()
    val doctors: MutableLiveData<DoctorResponse>
        get() = _doctors

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData(false)
    val error: LiveData<Boolean>
        get() = _error

    fun loadDoctors(page: Int){
        viewModelScope.launch {
            doctorRepository.fetchDoctor(page)
                .onStart { _loading.value = true }
                .catch { _error.value = true }
                .onCompletion { _loading.value = false }
                .collect {

                    limitPages = it.limit_page
                    _doctors.value = it


                }
        }

    }
}