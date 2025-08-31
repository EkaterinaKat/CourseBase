package com.katyshevtseva.features_content.domain.usecase

import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.domain.model.SortMethod
import com.katyshevtseva.features_content.domain.repo.CourseRepository
import javax.inject.Inject

class GetAllCoursesUseCase @Inject constructor(
    private val courseRepository: CourseRepository
) {

    suspend operator fun invoke(sortMethod: SortMethod?): List<Course> {
        return courseRepository.getAllCourses(sortMethod)
    }
}