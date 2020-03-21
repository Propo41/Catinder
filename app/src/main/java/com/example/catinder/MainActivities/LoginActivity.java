package com.example.catinder.MainActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.catinder.AlertDialogs.IncorrectCredentialsDialog;
import com.example.catinder.R;

public class LoginActivity extends AppCompatActivity {

    private String email= "null";
    private String pass = "null";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //hide the title bar

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            this.email = bundle.getString("email");
            this.pass = bundle.getString("pass");
        }

        setContentView(R.layout.activity_main);
    }

    public void signIn_clicked(View view){
        EditText emailView = findViewById(R.id.prompt_email_login);
        EditText passView = findViewById(R.id.prompt_password_login);
        String enteredEmail = emailView.getText().toString();
        String enteredPass = passView.getText().toString();

        if(enteredEmail.equals(this.email) && enteredPass.equals(this.pass)){
            Toast.makeText(LoginActivity.this, "Signed in successfully" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, Dashboard.class));
        }else{
            // show alert dialog: incorrect credentials
            IncorrectCredentialsDialog alertDialog = new IncorrectCredentialsDialog();
            alertDialog.show(getSupportFragmentManager(), "incorrect credentials");
        }
    }

    public void signUp_clicked(View view){
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }
}
