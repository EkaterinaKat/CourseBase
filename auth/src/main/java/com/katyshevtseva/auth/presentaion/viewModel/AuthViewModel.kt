package com.katyshevtseva.auth.presentaion.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(
) : ViewModel() {

    private val _errorLD = MutableLiveData<String>()
    val errorLD: LiveData<String>
        get() = _errorLD

    private val _successLD = MutableLiveData<Unit>()
    val successLD: LiveData<Unit>
        get() = _successLD

    fun login(email: String, pass: String) {
        Log.i("tag852741963", "$email $pass")
    }
}