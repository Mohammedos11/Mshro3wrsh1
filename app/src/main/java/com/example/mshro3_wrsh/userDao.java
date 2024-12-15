package com.example.mshro3_wrsh;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface userDao {
    @Insert
    void insertUser (user_log user);
    @Delete
    void deleteUser (user_log user);
    @Query("SELECT * FROM user_log WHERE username = :username AND password = :password LIMIT 1")
    user_log getUserByUsernameAndPassword(String username, String password);

    @Query("SELECT * FROM user_log WHERE email = :email LIMIT 1")
    user_log getUserByEmail(String email);

    @Query("UPDATE user_log SET password = :newPassword WHERE email = :email")
    int updatePassword(String newPassword, String email);

    @Query("select * from user_log ")
    LiveData<List<user_log>> getAllUsers();



}
