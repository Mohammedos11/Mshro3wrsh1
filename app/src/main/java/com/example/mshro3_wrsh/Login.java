package com.example.mshro3_wrsh;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Login extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    EditText email_in;
    EditText password_in;
    Button login_in;
    ImageView eye;
    TextView Forgot;
    private boolean isPasswordVisible = false;
    private MyRoomDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // تهيئة العناصر من واجهة المستخدم
        textView = findViewById(R.id.Sing_up);
        Forgot = findViewById(R.id.Forgot);
        imageView = findViewById(R.id.back);
        email_in = findViewById(R.id.Emaill);
        password_in = findViewById(R.id.Passwordd);
        login_in = findViewById(R.id.login);
        eye = findViewById(R.id.eye);

        // تهيئة قاعدة البيانات
        MyRoomDatabase db = MyRoomDatabase.getInstance(this); // تأكد من أن هذه الطريقة تُرجع الكائن بشكل صحيح
        database = db; // تهيئة المتغير database لكي نتمكن من استخدامه في العمليات التالية

        // إعداد أحداث النقر للأزرار
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, singup.class);
            startActivity(intent);
        });

        Forgot.setOnClickListener(v -> {
            Intent i = new Intent(Login.this, reset_password.class);
            startActivity(i);
        });

        imageView.setOnClickListener(v -> finish());

        login_in.setOnClickListener(v -> {
            String username = email_in.getText().toString();
            String password = password_in.getText().toString();

            // التأكد من أن الحقول غير فارغة
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(Login.this, "الرجاء إدخال اسم المستخدم وكلمة المرور", Toast.LENGTH_SHORT).show();
                return;
            }

            // تنفيذ التحقق في خيط منفصل
            new Thread(() -> {
                if (database != null) {
                    // التحقق من بيانات المستخدم
                    user_log user = database.userDao().getUserByUsernameAndPassword(username, password);

                    runOnUiThread(() -> {
                        if (user != null) {
                            // إذا تم العثور على المستخدم
                            Intent intent = new Intent(Login.this, HomePage.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // إذا لم يتم العثور على المستخدم
                            Toast.makeText(Login.this, "اسم المستخدم أو كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    // إذا كانت قاعدة البيانات لم تتهيأ
                    runOnUiThread(() -> {
                        Toast.makeText(Login.this, "حدث خطأ في الاتصال بقاعدة البيانات", Toast.LENGTH_SHORT).show();
                    });
                }
            }).start();
        });

        eye.setOnClickListener(v -> togglePasswordVisibility());
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            password_in.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
            eye.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.SRC_IN);
            eye.setImageResource(R.drawable.baseline_remove_red_eye_24); // عين مغلقة
            isPasswordVisible = false;
        } else {
            password_in.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
            eye.setColorFilter(ContextCompat.getColor(this, R.color.bb), PorterDuff.Mode.SRC_IN);
            eye.setImageResource(R.drawable.eye); // عين مفتوحة
            isPasswordVisible = true;
        }
        password_in.setSelection(password_in.length()); // إعادة المؤشر إلى نهاية النص
    }
}
