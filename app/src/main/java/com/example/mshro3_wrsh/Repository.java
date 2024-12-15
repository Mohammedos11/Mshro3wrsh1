package com.example.mshro3_wrsh;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    CoursesDao coursesDao ;
    TeacherDao teacherDao ;
    userDao userDaoo ;

    public Repository (Application application){
        MyRoomDatabase dp = MyRoomDatabase.getDatabase(application);
        coursesDao = dp.coursesDao();
        userDaoo = dp.userDao();
        teacherDao =dp.teacherDao();

   }


    void insertCourse (Courses courses){

        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                coursesDao.insertCourse(courses);
            }
        });
    }

    void updateCourse (Courses courses){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                coursesDao.updateCourse(courses);
            }
        });
    }

    void deleteCourse (Courses courses){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                coursesDao.deleteCourse(courses);
            }
        });
    }

    LiveData<List<Courses>> getAllCourses(){
        return coursesDao.getAllCourses();
    }
// teacher

  void insertTeacher (Teacher teacher){

        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                teacherDao.insertTeacher(teacher);
            }
        });
   }


    void updateTeacher (Teacher teacher){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                teacherDao.updateTeacher(teacher);
            }
        });
    }


    void deleteTeacher (Teacher teacher){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                teacherDao.deleteTeacher(teacher);
            }
        });
    }


    LiveData<List<Teacher>> getAllTeacher(){
        return teacherDao.getAllTeacher();
    }

    // user

    void deleteUser(user_log user){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
               userDaoo.getAllUsers();
            }
        });
    }



    void insertUser (user_log user){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDaoo.insertUser(user);
            }
        });
    }


    user_log getUserByUsernameAndPassword(String username, String password){
        return userDaoo.getUserByUsernameAndPassword( username, password);

    }


    user_log getUserByEmail(String email){
        return userDaoo.getUserByEmail(email);

    }

    int updatePassword(String newPassword , String oldPassword){
        return userDaoo.updatePassword(oldPassword , newPassword);

    }

    LiveData<List<user_log>> getAllUsers(){
        return userDaoo.getAllUsers();
    }



}







