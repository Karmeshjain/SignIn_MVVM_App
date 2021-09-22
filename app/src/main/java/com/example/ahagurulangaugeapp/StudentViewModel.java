package com.example.ahagurulangaugeapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private RepositoryStudent mRepository;

    private final LiveData<List<StudentData>> mAllStudents;

    public StudentViewModel (Application application) {
        super(application);
        mRepository = new RepositoryStudent(application);
        mAllStudents = mRepository.getAllStudent();
    }

    LiveData<List<StudentData>> getAllStudents() { return mAllStudents; }

    public void insert(StudentData studentData) { mRepository.insert(studentData); }
}
