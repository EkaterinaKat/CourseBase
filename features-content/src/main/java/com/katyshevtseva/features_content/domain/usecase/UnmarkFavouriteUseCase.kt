package com.katyshevtseva.features_content.domain.usecase

import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.domain.repo.CourseRepository
import javax.inject.Inject

class UnmarkFavouriteUseCase @Inject constructor(
    private val courseRepository: CourseRepository
) {

    suspend operator fun invoke(course: Course): Boolean {
        return courseRepository.unmarkFavourite(course)
    }
}