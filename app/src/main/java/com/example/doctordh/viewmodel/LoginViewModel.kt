package com.example.doctordh.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doctordh.data.Interceptor.Authorization
import com.example.doctordh.data.repository.LoginRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

class LoginViewModel(private val repositoryLogin: LoginRepository = LoginRepository.instance) :
    ViewModel() {
    private val _sucess = MutableLiveData<String>("")
    val sucess: LiveData<String>
        get() = _sucess

    private val _error = MutableLiveData(false)
    val error: LiveData<Boolean> = _error

    fun login(email: String, password: String) = viewModelScope.launch {
        repositoryLogin
            .login(email, password)
            .catch { _error.value = true }
            .collect {
                _sucess.value = it.token

                Authorization.token = it.token
            }


    }


}