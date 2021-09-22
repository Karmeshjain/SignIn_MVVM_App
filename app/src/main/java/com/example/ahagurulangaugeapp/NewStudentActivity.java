package com.example.ahagurulangaugeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class NewStudentActivity extends AppCompatActivity {
    public static final String NAME = "NAMEOFSTUDENT";
    public static final String CC = "COUNTRYCODE";
    public static final String PHNUM = "PHONENUMBER";

    private EditText mstudentNameEditText;
    private EditText mstudentCountryCode;
    private EditText mstudentPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
        mstudentNameEditText = findViewById(R.id.studentName);
        mstudentCountryCode =findViewById(R.id.CountryCode);
        mstudentPhoneNumber=findViewById(R.id.PhoneNumber);
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mstudentNameEditText.getText())||TextUtils.isEmpty(mstudentPhoneNumber.getText())||TextUtils.isEmpty(mstudentCountryCode.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                StudentData student =new StudentData();
                student.setStudentName(mstudentNameEditText.getText().toString());
                student.setPhoneNumber(mstudentPhoneNumber.getText().toString());
                student.setCountryCode(mstudentCountryCode.getText().toString());
                replyIntent.putExtra(NAME, student.getStudentName());
                replyIntent.putExtra(PHNUM,student.getPhoneNumber());
                replyIntent.putExtra(CC,student.getCountryCode());
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}