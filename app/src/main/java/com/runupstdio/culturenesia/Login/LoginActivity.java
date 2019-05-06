package com.runupstdio.culturenesia.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.runupstdio.culturenesia.BottomNavbarActivity;
import com.runupstdio.culturenesia.R;
import com.runupstdio.culturenesia.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    TextView register;
    EditText email, password;
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.register_From_Login);
        email = findViewById(R.id.email_Login);
        password = findViewById(R.id.password_Login);
        mLogin = findViewById(R.id.btn_Login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, BottomNavbarActivity.class));
            }
        });
    }
}
