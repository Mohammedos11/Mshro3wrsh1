package com.example.mshro3_wrsh;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Courses.class,Teacher.class,user_log.class},version = 2, exportSchema = false)
public abstract class MyRoomDatabase extends RoomDatabase {

    public abstract CoursesDao coursesDao();
    public abstract userDao userDao();
    public abstract TeacherDao teacherDao();
    private static volatile MyRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MyRoomDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyRoomDatabase.class, "my_database")

                            .addMigrations(new Migration(1, 2) {
                                @Override
                                public void migrate(SupportSQLiteDatabase database) {
                                    // عملية الهجرة، على سبيل المثال:
                                    // إضافة عمود جديد لجدول المستخدم
                                    database.execSQL("ALTER TABLE user_log ADD COLUMN new_column INTEGER DEFAULT 0 NOT NULL");
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
