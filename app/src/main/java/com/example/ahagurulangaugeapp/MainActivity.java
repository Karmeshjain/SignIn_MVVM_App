package com.example.ahagurulangaugeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private StudentViewModel mstudentViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final StudentAdapter adapter = new StudentAdapter(new StudentAdapter.StudentDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NewStudentActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
        mstudentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
        mstudentViewModel.getAllStudents().observe(this, students -> {
            // Update the cached copy of the words in the adapter.

            adapter.submitList(students);
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            StudentData student = new StudentData();
            student.setStudentName(data.getStringExtra(NewStudentActivity.NAME));
            student.setCountryCode(data.getStringExtra(NewStudentActivity.CC));
            student.setPhoneNumber(data.getStringExtra(NewStudentActivity.PHNUM));
            mstudentViewModel.insert(student);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}