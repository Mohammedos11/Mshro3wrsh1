package com.example.mshro3_wrsh;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Courses.class,Teacher.class,user_log.class},version = 1, exportSchema = false)
public abstract class MyRoomDatabase extends RoomDatabase {

    public abstract CoursesDao coursesDao();
    public abstract userDao userDao();
    public abstract TeacherDao teacherDao();
    private static volatile MyRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MyRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyRoomDatabase.class, "my_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
