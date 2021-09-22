package com.example.ahagurulangaugeapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO_Student {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     void insert(StudentData studentData);         //in kotlin we use suspend function to make it this process on other
                                                  //thread so implement that suspend function in java here accordingly

    @Query("DELETE FROM studenttable")
    void deleteAll();

    @Query("SELECT * FROM studenttable ORDER BY id ASC")
    LiveData<List<StudentData>> getStudentData();
}
