package com.katyshevtseva.features_content.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.katyshevtseva.features_content.data.local.entity.CourseEntity

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun add(course: CourseEntity)

    @Query("SELECT * FROM course")
    suspend fun getCourses(): List<CourseEntity>

    @Query("DELETE FROM course WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM course WHERE id = :id)")
    suspend fun existsById(id: Int): Boolean
}