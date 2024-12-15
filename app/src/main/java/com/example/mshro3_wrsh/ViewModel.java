package com.example.mshro3_wrsh;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    Repository repository ;
    public ViewModel(@NonNull Application application) {
        super(application);
        repository =new Repository(application);
    }
    void insertCourse (Courses courses){repository.insertCourse(courses);}

    void updateCourse (Courses courses){repository.updateCourse(courses);}

    void deleteCourse (Courses courses){repository.deleteCourse(courses);
    }

    LiveData<List<Courses>> getAllCourses(){
        return repository.getAllCourses();
    }
// teacher

    void insertTeacher (Teacher teacher){  repository.insertTeacher(teacher);}


    void updateTeacher (Teacher teacher){  repository.updateTeacher(teacher);}


    void deleteTeacher (Teacher teacher){  repository.deleteTeacher(teacher);}


    LiveData<List<Teacher>> getAllTeacher(){
        return repository.getAllTeacher();
    }



    void deleteUser (user_log user){
                repository.deleteUser(user);

    }

    LiveData<List<user_log>> getAllUsers(){
        return repository.getAllUsers();
    }
//

    user_log getUserByUsernameAndPassword(String username, String password){
        return repository.getUserByUsernameAndPassword( username, password);

    }


    user_log getUserByEmail(String email){
        return repository.getUserByEmail(email);

    }

    int updatePassword(String newPassword ,String oldPassword){
        return repository.updatePassword(oldPassword , newPassword);

    }

}
