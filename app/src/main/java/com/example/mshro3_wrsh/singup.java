package com.example.mshro3_wrsh;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class singup extends AppCompatActivity {

    EditText username_ed ;
    EditText password_ed ;
    EditText email_ed ;
    EditText phone_ed ;
    ImageView imageView ;
    Button SingUp_ed;
    ImageView eye ;
    private boolean isPasswordVisible = false;
    private MyRoomDatabase room ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_singup);
        username_ed =findViewById(R.id.Username);
        password_ed =findViewById(R.id.Password);
        email_ed =findViewById(R.id.Email);
        phone_ed = findViewById(R.id.phone);
        SingUp_ed = findViewById(R.id.singup);
        imageView = findViewById(R.id.back);
        eye = findViewById(R.id.eye);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        room =MyRoomDatabase.getInstance(this);
        SingUp_ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String username =username_ed .getText().toString();
                String password = password_ed.getText().toString();
                String email = email_ed.getText().toString();
                String phone = phone_ed.getText().toString();


                if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(singup.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                user_log newUser = new user_log();
                newUser.username = username;
                newUser.password = password;
                newUser.email = email;
                newUser.phone = phone;


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        room.userDao().insertUser(newUser);  // إدخال البيانات
                    }
                }).start();

                Toast.makeText(singup.this, "Account created successfully!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(singup.this, HomePage.class);
                startActivity(intent);
                finish();


            }
        });

        eye.setOnClickListener(v -> {
            togglePasswordVisibility();
        });

    }

    private void togglePasswordVisibility() {

        if (isPasswordVisible) {
            password_ed.setTransformationMethod(PasswordTransformationMethod.getInstance());
            eye.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.SRC_IN);
            eye.setImageResource(R.drawable.baseline_remove_red_eye_24);
            isPasswordVisible = false;
        } else {
            password_ed.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            eye.setColorFilter(ContextCompat.getColor(this, R.color.bb), PorterDuff.Mode.SRC_IN);
            eye.setImageResource(R.drawable.eye);
            isPasswordVisible = true;
        }
        password_ed.setSelection(password_ed.length());


    }
}