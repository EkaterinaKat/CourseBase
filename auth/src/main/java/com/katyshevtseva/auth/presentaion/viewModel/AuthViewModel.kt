package com.katyshevtseva.auth.presentaion.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katyshevtseva.auth.domain.usecase.CheckCredentialsUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val checkCredentialsUseCase: CheckCredentialsUseCase
) : ViewModel() {

    private val _credentialsAreValidLD = MutableLiveData<Boolean>()
    val credentialsAreValidLD: LiveData<Boolean>
        get() = _credentialsAreValidLD

    private var checkCredentialsDelayJob: Job? = null

    fun onCredentialsInput(email: String, pass: String) {
        checkCredentialsDelayJob?.cancel()
        checkCredentialsDelayJob = viewModelScope.launch {
            delay(500)
            _credentialsAreValidLD.value = checkCredentialsUseCase.invoke(email, pass)
        }
    }
}