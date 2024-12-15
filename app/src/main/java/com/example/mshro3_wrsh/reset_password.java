package com.example.mshro3_wrsh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class reset_password extends AppCompatActivity {


    EditText oldPasswordInput ;
    EditText newPasswordInput ;
    EditText confirmNewPasswordInput ;
    Button changePasswordButton ;
     MyRoomDatabase db;
     userDao dao ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reset_password);


        oldPasswordInput = findViewById(R.id.old_password_input);
        newPasswordInput = findViewById(R.id.new_password_input);
        confirmNewPasswordInput = findViewById(R.id.confirm_new_password_input);
        changePasswordButton = findViewById(R.id.change_password_button);


        db = Room.databaseBuilder(getApplicationContext(), MyRoomDatabase.class, "user-database")
                .allowMainThreadQueries()
                .build();
        dao = db.userDao();

        // ربط زر تغيير كلمة السر بوظيفة
        changePasswordButton.setOnClickListener(v -> handleChangePassword());
    }

    private void handleChangePassword() {
        String oldPassword = oldPasswordInput.getText().toString().trim();
        String newPassword = newPasswordInput.getText().toString().trim();
        String confirmNewPassword = confirmNewPasswordInput.getText().toString().trim();

        if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
            Toast.makeText(this, "يرجى تعبئة جميع الحقول.", Toast.LENGTH_SHORT).show();
        } else if (!newPassword.equals(confirmNewPassword)) {
            Toast.makeText(this, "كلمات السر الجديدة غير متطابقة.", Toast.LENGTH_SHORT).show();
        } else {
            // نحقق من كلمة السر القديمة ونعمل التحديث إذا كانت صحيحة
            changePassword("user@example.com", oldPassword, newPassword); // استبدل بالبريد الفعلي
        }
    }

    private void changePassword(String email, String oldPassword, String newPassword) {
        new Thread(() -> {
            user_log currentUser = dao.getUserByEmail(email); // استرجاع المستخدم من قاعدة البيانات
            if (currentUser != null) {
                if (currentUser.getPassword().equals(oldPassword)) { // تحقق من كلمة السر القديمة
                    int rowsUpdated = dao.updatePassword(newPassword, email); // تحديث كلمة السر
                    if (rowsUpdated > 0) {
                        runOnUiThread(() -> {
                            Toast.makeText(this, "تم تغيير كلمة السر بنجاح.", Toast.LENGTH_SHORT).show();
                        });
                    } else {
                        runOnUiThread(() -> {
                            Toast.makeText(this, "فشل في تغيير كلمة السر.", Toast.LENGTH_SHORT).show();
                        });
                    }
                } else {
                    runOnUiThread(() -> {
                        Toast.makeText(this, "كلمة السر القديمة غير صحيحة.", Toast.LENGTH_SHORT).show();
                    });
                }
            } else {
                runOnUiThread(() -> {
                    Toast.makeText(this, "المستخدم غير موجود.", Toast.LENGTH_SHORT).show();
                });
            }
        }).start();
    }

}

