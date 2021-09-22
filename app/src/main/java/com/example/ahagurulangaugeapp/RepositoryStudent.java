package com.example.ahagurulangaugeapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RepositoryStudent
{
    private DAO_Student mStudentDao;
    private LiveData<List<StudentData>> mAllStudent;


    RepositoryStudent(Application application) {
        StudentRoomDatabase db = StudentRoomDatabase.getDatabase(application);
        mStudentDao = db.StudentDao();
        mAllStudent = mStudentDao.getStudentData();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<StudentData>> getAllStudent() {
        return mAllStudent;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(StudentData studentData) {
        StudentRoomDatabase.databaseWriteExecutor.execute(() -> {
            mStudentDao.insert(studentData);
        });
    }
}
