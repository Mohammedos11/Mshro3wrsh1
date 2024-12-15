package com.example.mshro3_wrsh;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeacherDao {

    @Insert
    void insertTeacher (Teacher teacher);

    @Update
    void updateTeacher (Teacher teacher);

    @Delete
    void deleteTeacher (Teacher teacher);

    @Query("select * from Teacher ")
    LiveData<List<Teacher>> getAllTeacher();



}
