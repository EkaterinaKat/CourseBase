package com.katyshevtseva.features_content.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.domain.model.SortMethod
import com.katyshevtseva.features_content.domain.model.SortMethod.PUBLISH_DATE_ASC
import com.katyshevtseva.features_content.domain.model.SortMethod.PUBLISH_DATE_DESC
import com.katyshevtseva.features_content.domain.usecase.GetAllCoursesUseCase
import com.katyshevtseva.features_content.domain.usecase.MarkFavouriteUseCase
import com.katyshevtseva.features_content.domain.usecase.UnmarkFavouriteUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getAllCoursesUseCase: GetAllCoursesUseCase,
    private val markFavouriteUseCase: MarkFavouriteUseCase,
    private val unmarkFavouriteUseCase: UnmarkFavouriteUseCase
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

    private var sortMethod: SortMethod? = null

    init {
        loadCourses()
    }

    fun loadCourses() {
        viewModelScope.launch {
            _loadingLD.value = true
            try {
                _coursesLD.value = getAllCoursesUseCase(sortMethod)
            } catch (e: Exception) {
                _errorLD.value = Unit
            }
            _loadingLD.value = false
        }
    }

    fun likeButtonListener(course: Course) {
        viewModelScope.launch {
            val success = if (course.favourite) {
                unmarkFavouriteUseCase(course)
            } else {
                markFavouriteUseCase(course)
            }
            if (success) {
                loadCourses()
            }
        }
    }

    fun sortButtonListener() {
        sortMethod = when (sortMethod) {
            PUBLISH_DATE_DESC -> {
                PUBLISH_DATE_ASC
            }

            PUBLISH_DATE_ASC, null -> {
                PUBLISH_DATE_DESC
            }
        }
        loadCourses()
    }
}