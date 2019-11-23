package com.gmail.gwonii.jobrom.controller;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.model.JobListModel;

import java.util.ArrayList;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.JobListViewHolder> {

    private ArrayList<JobListModel> jobList;
    private int count = 0;
    private OnListItemSelectedInterface mListener;



    public interface OnListItemSelectedInterface {
        void onItemSelected(View v, int position);
    }

    public class JobListViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView summary;
        protected TextView salary;

        public TextView getName() {
            return name;
        }

        public TextView getSummary() {
            return summary;
        }

        public TextView getSalary() {
            return salary;
        }

        public JobListViewHolder(View view ) {

            super(view);
            this.name = view.findViewById(R.id.tv_search_result_job_name);
            this.summary = view.findViewById(R.id.tv_search_result_job_body);
            this.salary = view.findViewById(R.id.tv_search_result_job_salary);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Recyclerview", "position = "+ getAdapterPosition());

                    mListener.onItemSelected(v, getAdapterPosition());

                }
            });


            // LongClick에 대한 처리도 할 수 있다.
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
        }
    }

    public JobListAdapter(ArrayList<JobListModel> list, OnListItemSelectedInterface listener) {
        this.jobList = list;
        this.mListener = listener;
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
        viewholder.summary.setText(jobList.get(position).getSummary());
        viewholder.salary.setText("평균연봉 " +jobList.get(position).getSalary() + " 만원");

    }

    @Override
    public int getItemCount() {

        return (null != jobList ? jobList.size() : 0);
    }

}
