package com.example.mshro3_wrsh;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Courses {

    @PrimaryKey
    private int Courses_id ;
    private String name_course;
    private int Image;
    private int Evaluation;
    private int price;
    private String category;
    private String Description ;
    private int Num_of_student ;
    private String Teacher_name ;
    private int Number_of_course_hours ;


    public Courses() {
    }

    public Courses(int courses_id, String name_course, int image, int evaluation, int price, String category, String description, int num_of_student, String teacher_name, int number_of_course_hours) {
        Courses_id = courses_id;
        this.name_course = name_course;
        Image = image;
        Evaluation = evaluation;
        this.price = price;
        this.category = category;
        Description = description;
        Num_of_student = num_of_student;
        Teacher_name = teacher_name;
        Number_of_course_hours = number_of_course_hours;
    }


    public int getCourses_id() {
        return Courses_id;
    }

    public void setCourses_id(int courses_id) {
        Courses_id = courses_id;
    }

    public String getName_course() {
        return name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getEvaluation() {
        return Evaluation;
    }

    public void setEvaluation(int evaluation) {
        Evaluation = evaluation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getNum_of_student() {
        return Num_of_student;
    }

    public void setNum_of_student(int num_of_student) {
        Num_of_student = num_of_student;
    }

    public String getTeacher_name() {
        return Teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        Teacher_name = teacher_name;
    }

    public int getNumber_of_course_hours() {
        return Number_of_course_hours;
    }

    public void setNumber_of_course_hours(int number_of_course_hours) {
        Number_of_course_hours = number_of_course_hours;
    }
}
