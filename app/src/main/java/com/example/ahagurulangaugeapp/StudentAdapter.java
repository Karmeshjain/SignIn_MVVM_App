package com.example.ahagurulangaugeapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends ListAdapter<StudentData, StudentViewHolder> {


    protected StudentAdapter(@NonNull DiffUtil.ItemCallback<StudentData> diffCallback) {
        super(diffCallback);
    }

    protected StudentAdapter(@NonNull AsyncDifferConfig<StudentData> config) {
        super(config);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return StudentViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        StudentData current = getItem(position);
        holder.bind(current);
    }

    static class StudentDiff extends DiffUtil.ItemCallback<StudentData> {

        @Override
        public boolean areItemsTheSame(@NonNull StudentData oldItem, @NonNull StudentData newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull StudentData oldItem, @NonNull StudentData newItem) {
            return oldItem.getId()==newItem.getId();
        }
    }
}