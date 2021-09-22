package com.example.ahagurulangaugeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private final TextView studentNameTextView;
    private final TextView studentCountryCodeTextView;
    private final TextView studentPhoneNumberTextView;
    private StudentViewHolder(View itemView) {
        super(itemView);
        studentNameTextView = itemView.findViewById(R.id.studentName);
        studentCountryCodeTextView=itemView.findViewById(R.id.CountryCode);
        studentPhoneNumberTextView=itemView.findViewById(R.id.PhoneNumber);
    }

    public static StudentViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new StudentViewHolder(view);
    }
    public void bind(StudentData studentData) {
        studentCountryCodeTextView.setText(studentData.getCountryCode());
        studentNameTextView.setText(studentData.getStudentName());
        studentPhoneNumberTextView.setText(studentData.getPhoneNumber());
    }
}
