package com.example.mshro3_wrsh;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class user_log {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String username;
    public String password;
    public String email;
    public String phone;
    private int Student_num;
    private String Student_name ;
    private String Courses_name ;
    private int Courses_id ;

    public user_log() {
    }
    public user_log(int id, String username, String password, String email, String phone, int student_num, String student_name, String courses_name, int courses_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        Student_num = student_num;
        Student_name = student_name;
        Courses_name = courses_name;
        Courses_id = courses_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStudent_num() {
        return Student_num;
    }

    public void setStudent_num(int student_num) {
        Student_num = student_num;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public String getCourses_name() {
        return Courses_name;
    }

    public void setCourses_name(String courses_name) {
        Courses_name = courses_name;
    }

    public int getCourses_id() {
        return Courses_id;
    }

    public void setCourses_id(int courses_id) {
        Courses_id = courses_id;
    }
}
