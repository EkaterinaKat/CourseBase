package com.katyshevtseva.features_content.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.domain.usecase.GetAllCoursesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getAllCoursesUseCase: GetAllCoursesUseCase
) : ViewModel() {

    private val _coursesLD = MutableLiveData<List<Course>>()
    val coursesLD: LiveData<List<Course>>
        get() = _coursesLD

    private val _errorLD = MutableLiveData<Unit>()
    val errorLD: LiveData<Unit>
        get() = _errorLD

    private val _loadingLD = MutableLiveData<Boolean>()
    val loadingLD: LiveData<Boolean>
        get() = _loadingLD

    init {
        loadCourses()
    }

    fun loadCourses() {
        viewModelScope.launch {
            _loadingLD.value = true
            try {
                _coursesLD.value = getAllCoursesUseCase()
            } catch (e: Exception) {
                _errorLD.value = Unit
            }
            _loadingLD.value = false
        }
    }
}