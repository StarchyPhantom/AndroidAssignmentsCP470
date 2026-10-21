package com.example.androidassignments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    EditText loginNameEditText = null;
    EditText loginPasswordEditText = null;

    String loginName = "";
    String loginPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LoginActivity", "onCreate() called");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button loginButton = findViewById(R.id.LoginButton);
        loginName = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("LoginNameField", "email@domain.com");
        loginPassword = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("LoginPasswordField", "email@domain.com");

        loginNameEditText = findViewById(R.id.LoginNameField);
        loginPasswordEditText = findViewById(R.id.LoginPasswordField);
        loginNameEditText.setText(loginName);
        loginPasswordEditText.setText(loginPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loginNameEditText = findViewById(R.id.LoginNameField);
                loginName = loginNameEditText.getText().toString();
                loginPasswordEditText = findViewById(R.id.LoginPasswordField);
                loginPassword = loginPasswordEditText.getText().toString();
                //loginName = getSharedPreferences("LoginNameField", MODE_PRIVATE).getString("email", "");

                if (loginName != null && (loginName.split("@").length == 2 && loginName.split("@")[1].split("\\.").length == 2) && !loginPassword.isEmpty()) {
                    getSharedPreferences("MyPrefs", MODE_PRIVATE).edit().putString("LoginNameField", loginName).apply();
                    getSharedPreferences("MyPrefs", MODE_PRIVATE).edit().putString("LoginPasswordField", loginPassword).apply();
                    loginName = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("LoginNameField", "email@domain.com");
                    loginPassword = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("LoginPasswordField", "email@domain.com");
                    Log.i("LoginActivity", "We have: " + loginName + " | " + loginPassword);
                    goToMain(v);
                }
                else
                {
                    AlertDialog.Builder builder =
                        new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Invalid Email or empty password");
                // builder.setIcon(R.drawable.ic_launcher_foreground);
                builder.show();
                builder.setCancelable(true);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LoginActivity", "onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LoginActivity", "onStart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LoginActivity", "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LoginActivity", "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LoginActivity", "onDestroy() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i("LoginActivity", "onSaveInstanceState() called");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("LoginActivity", "onRestoreInstanceState() called");
    }
    public void goToMain(View view) {
        // go back to main page  in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}