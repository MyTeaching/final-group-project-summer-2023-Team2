package com.example.workoutapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    Button btnlogin;
    TextInputEditText etUserName;
    TextInputEditText etPassword;
    TextView registerHere;
    FirebaseAuth fireAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.btnLogin);
        etUserName = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPass);
        fireAuth = FirebaseAuth.getInstance();
        registerHere = findViewById(R.id.tvRegisterHere);

        btnlogin.setOnClickListener(view -> {
            logUser();
        });
        registerHere.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }

    protected void onStart() {
        super.onStart();
        FirebaseUser user = fireAuth.getCurrentUser();
        if(user == null) {

        }
    }

    private void logUser() {
        String user = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(user)){
            etUserName.setError("Username cannot be empty");
            etUserName.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
        }else{
            fireAuth.signInWithEmailAndPassword(user,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, Welcome.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}