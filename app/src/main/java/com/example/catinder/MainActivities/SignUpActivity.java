package com.example.catinder.MainActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.catinder.AlertDialogs.DatePickerFragment;
import com.example.catinder.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide(); //hide the title bar
        setContentView(R.layout.activity_sign_up);

        Spinner genderSpinner = findViewById(R.id.genderSelect_spinner);
        //bind the array declared in res/values/strings/genders with the adapter
        // and set the type of spinner view to simple_spinner_item
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item);
        // set the drop down style to simple_spinner_dropdown_item
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        genderSpinner.setOnItemSelectedListener(this);


    }

    public void confirm_clicked(View view) {
        Toast.makeText(SignUpActivity.this, "Account Created Successfully!" , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        EditText emailView = findViewById(R.id.prompt_email);
        EditText passView = findViewById(R.id.prompt_password);

        intent.putExtra("email", emailView.getText().toString());
        intent.putExtra("pass", passView.getText().toString());
        startActivity(intent);

    }

    public void datePicker_clicked(View view) {
        new DatePickerFragment().show(getSupportFragmentManager(), "date picker");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(),selected , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateString = DateFormat.getDateInstance().format(c.getTime());
        Toast.makeText(SignUpActivity.this, dateString , Toast.LENGTH_SHORT).show();


    }
}
