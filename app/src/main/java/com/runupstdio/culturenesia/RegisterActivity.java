package com.runupstdio.culturenesia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.runupstdio.culturenesia.Login.LoginActivity;
import com.runupstdio.culturenesia.Splash.SplashActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    TextView login;
    EditText email, password;
    Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.login_From_Register);
        email = findViewById(R.id.email_Register);
        password = findViewById(R.id.password_Register);
        mRegister = findViewById(R.id.btn_Register);
        progressDialog = new ProgressDialog(this);

        login.setOnClickListener(this);
        mRegister.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null){
            
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(RegisterActivity.this, SplashActivity.class));
        finish();
    }

    private void signUp() {
        Log.d(TAG, "signUp");
        //showProgressDialog();
        final String mEmail = email.getText().toString().trim();
        String mPassword = password.getText().toString().trim();

        if(TextUtils.isEmpty(mEmail)){
            Toast.makeText(this, "Please enter email.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mPassword)){
            Toast.makeText(this, "Please enter password.", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering user. . .");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(mEmail, mPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()  {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Kedaftar Lurd", Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(getBaseContext(), BottomNavbarActivity.class);
                            login.putExtra("mssidn", mEmail);
                            startActivity(login);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Gagal Lurd", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == mRegister){
            signUp();
        }
        else if (v == login){
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        }
    }
}
