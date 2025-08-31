package com.katyshevtseva.features_content.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.domain.usecase.GetFavouritesUseCase
import com.katyshevtseva.features_content.domain.usecase.MarkFavouriteUseCase
import com.katyshevtseva.features_content.domain.usecase.UnmarkFavouriteUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(
    private val getFavouritesUseCase: GetFavouritesUseCase,
    private val markFavouriteUseCase: MarkFavouriteUseCase,
    private val unmarkFavouriteUseCase: UnmarkFavouriteUseCase
) : ViewModel() {

    private val _coursesLD = MutableLiveData<List<Course>>()
    val coursesLD: LiveData<List<Course>>
        get() = _coursesLD

    private val _errorLD = MutableLiveData<Unit>()
    val errorLD: LiveData<Unit>
        get() = _errorLD

    init {
        loadCourses()
    }

    fun loadCourses() {
        viewModelScope.launch {
            try {
                _coursesLD.value = getFavouritesUseCase()
            } catch (e: Exception) {
                _errorLD.value = Unit
            }
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
}