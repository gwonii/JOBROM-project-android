package com.gmail.gwonii.jobrom.controller;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.model.JobModel;

import java.util.ArrayList;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.JobListViewHolder> {

    private ArrayList<JobModel> jobList;


    public class JobListViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView ability;
        protected TextView salary;


        public JobListViewHolder(View view) {

            super(view);
            this.name = view.findViewById(R.id.tv_search_result_job_name);
            this.ability = view.findViewById(R.id.tv_search_result_job_body);
            this.salary = view.findViewById(R.id.tv_search_result_job_salary);
        }
    }

    public JobListAdapter(ArrayList<JobModel> list) {
        this.jobList = list;
    }

    @Override
    public JobListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.job_list, viewGroup, false);

        JobListViewHolder viewHolder = new JobListViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JobListViewHolder viewholder, int position) {
//
//        viewholder.id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
//        viewholder.english.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
//        viewholder.korean.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
//
//        viewholder.id.setGravity(Gravity.CENTER);
//        viewholder.english.setGravity(Gravity.CENTER);
//        viewholder.korean.setGravity(Gravity.CENTER);

        viewholder.name.setText(jobList.get(position).getName());
        viewholder.ability.setText(jobList.get(position).getAbility());
        viewholder.salary.setText(jobList.get(position).getSalary());
    }

    @Override
    public int getItemCount() {
        return (null != jobList ? jobList.size() : 0);
    }

}
