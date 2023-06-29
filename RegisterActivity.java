package com.example.workoutapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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


public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    TextInputEditText etRegUserName;
    TextInputEditText etRegPassword;
    TextView loginHere;
    FirebaseAuth fireAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        etRegPassword = findViewById(R.id.etRegisterPass);
        etRegUserName = findViewById(R.id.etRegisterUsername);
        loginHere = findViewById(R.id.tvLogHere);

        fireAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view -> {
            createUser();
        });
        loginHere.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = fireAuth.getCurrentUser();
    }

    private void createUser() {
        String username = etRegUserName.getText().toString();
        String password = etRegPassword.getText().toString();
        if (TextUtils.isEmpty(username)) {
            etRegUserName.setError("Username cannot be empty");
            etRegUserName.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            etRegPassword.setError("Password cannot be empty");
            etRegPassword.requestFocus();
        } else {
            fireAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}