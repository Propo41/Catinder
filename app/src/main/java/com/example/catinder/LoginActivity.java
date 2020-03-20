package com.example.catinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //hide the title bar

        setContentView(R.layout.activity_main);
    }

    public void signIn_clicked(View view){
        startActivity(new Intent(LoginActivity.this, Dashboard.class));
    }

    public void signUp_clicked(View view){
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }
}
