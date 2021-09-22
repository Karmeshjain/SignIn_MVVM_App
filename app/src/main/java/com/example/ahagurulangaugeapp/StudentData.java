package com.example.ahagurulangaugeapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StudentTable")
public class StudentData {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "StudentsName")
    private String StudentName;
    @ColumnInfo(name = "CountryCodes")
    private String countryCode;
    @ColumnInfo(name = "PhoneDetails")
    private String PhoneNumber;

    public int getId() { return id; }

    public String getStudentName()
    {
        return StudentName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
