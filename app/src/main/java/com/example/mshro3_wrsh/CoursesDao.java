package com.example.mshro3_wrsh;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CoursesDao {

    @Insert
    void insertCourse (Courses courses);

    @Update
    void updateCourse (Courses courses);

    @Delete
    void deleteCourse (Courses courses);

    @Query("select * from Courses ")
    LiveData<List<Courses>> getAllCourses();
}
