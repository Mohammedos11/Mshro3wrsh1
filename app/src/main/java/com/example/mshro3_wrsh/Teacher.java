package com.example.mshro3_wrsh;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Teacher {

    private String Teacher_name ;
    @PrimaryKey
    private  int  Teacher_id;
    private String Courses_name ;
    private String  student_name ;

    public Teacher(String teacher_name, int teacher_id, String courses_name, String student_name) {
        Teacher_name = teacher_name;
        Teacher_id = teacher_id;
        Courses_name = courses_name;
        this.student_name = student_name;
    }

    public Teacher() {
    }

    public String getTeacher_name() {
        return Teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        Teacher_name = teacher_name;
    }

    public int getTeacher_id() {
        return Teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        Teacher_id = teacher_id;
    }

    public String getCourses_name() {
        return Courses_name;
    }

    public void setCourses_name(String courses_name) {
        Courses_name = courses_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
