package com.example.mshro3_wrsh;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
TextView textView ;
ImageView imageView ;
EditText email_in ;
EditText password_in ;
Button  login_in ;
ImageView eye ;
TextView Forgot ;
private boolean isPasswordVisible = false;
private MyRoomDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        textView = findViewById(R.id.Sing_up);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,singup.class);
                startActivity(intent);
            }
        });
        Forgot =findViewById(R.id.Forgot);

        Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,reset_password.class);
                startActivity(i);
            }
        });
        imageView = findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        email_in =findViewById(R.id.Emaill);
        password_in = findViewById(R.id.Passwordd);
        login_in = findViewById(R.id.login);
        eye = findViewById(R.id.eye);

        database = (MyRoomDatabase) database.userDao();

      login_in.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              String username = email_in.getText().toString();
              String password = password_in.getText().toString();

              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      user_log user = database.userDao().getUserByUsernameAndPassword(username, password);

                      runOnUiThread(() -> {
                          if (user != null) {

                              Intent intent = new Intent(Login.this, HomePage.class);
                              startActivity(intent);
                              finish();
                          } else {

                              Toast.makeText(Login.this, "اسم المستخدم أو كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show();
                          }
                      });
                  }
              }).start();


              new Thread(new Runnable() {
                  @Override
                  public void run() {

                      user_log user = new user_log();
                      user.username = "myusername";
                      user.password = "mypassword";
                      user.email = "email@example.com";
                      user.phone = "123456789";


                      database.userDao().insertUser(user);
                  }
              }).start();


          }
      });



        eye.setOnClickListener(v -> {
            togglePasswordVisibility();
        });

    }


    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // إخفاء كلمة المرور
            password_in.setTransformationMethod(PasswordTransformationMethod.getInstance());
            // تعيين الأيقونة إلى اللون الأصلي (عين مغلقة) عند إخفاء كلمة المرور
            eye.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.SRC_IN); // تغيير الأيقونة إلى اللون الأسود
            eye.setImageResource(R.drawable.baseline_remove_red_eye_24);  // الأيقونة الخاصة بعين مغلقة
            isPasswordVisible = false;
        } else {
            // إظهار كلمة المرور
            password_in.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            // تعيين الأيقونة إلى اللون الأزرق عند إظهار كلمة المرور
            eye.setColorFilter(ContextCompat.getColor(this, R.color.bb), PorterDuff.Mode.SRC_IN); // تغيير الأيقونة إلى اللون الأزرق
            eye.setImageResource(R.drawable.eye);  // الأيقونة الخاصة بعين مفتوحة
            isPasswordVisible = true;
        }
        // إعادة المؤشر إلى نهاية النص
        password_in.setSelection(password_in.length());


    }
}

