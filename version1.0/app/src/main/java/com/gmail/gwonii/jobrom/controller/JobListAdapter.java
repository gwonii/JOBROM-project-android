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

        protected String deliveredName;
        protected String deliveredSummary;
        protected String deliveredSalary;
        protected String deliveredDivision;
        protected String deliveredAbility;
        protected String deliveredPreparation;
        protected String deliveredEquality;
        protected String deliveredPotential;
        protected String deliveredOutlook;
        protected String deliveredEnvironment;
        protected String deliveredRequiredAbility;
        protected String deliveredKnowledge;



        public TextView getName() {
            return name;
        }

        public TextView getSummary() {
            return summary;
        }

        public TextView getSalary() {
            return salary;
        }

        public String getDeliveredName() {
            return deliveredName;
        }

        public String getDeliveredSummary() {
            return deliveredSummary;
        }

        public String getDeliveredSalary() {
            return deliveredSalary;
        }

        public String getDeliveredDivision() {
            return deliveredDivision;
        }

        public String getDeliveredAbility() {
            return deliveredAbility;
        }

        public String getDeliveredPreparation() {
            return deliveredPreparation;
        }

        public String getDeliveredEquality() {
            return deliveredEquality;
        }

        public String getDeliveredPotential() {
            return deliveredPotential;
        }

        public String getDeliveredOutlook() {
            return deliveredOutlook;
        }

        public String getDeliveredEnvironment() {
            return deliveredEnvironment;
        }

        public String getDeliveredRequiredAbility() {
            return deliveredRequiredAbility;
        }

        public String getDeliveredKnowledge() {
            return deliveredKnowledge;
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


        viewholder.deliveredName = jobList.get(position).getName();
        viewholder.deliveredSummary = jobList.get(position).getSummary();
        viewholder.deliveredSalary = jobList.get(position).getSalary();
        viewholder.deliveredDivision = jobList.get(position).getDivision();
        viewholder.deliveredAbility = jobList.get(position).getAbility();
        viewholder.deliveredPreparation = jobList.get(position).getPreparation();
        viewholder.deliveredEquality = jobList.get(position).getEquality();
        viewholder.deliveredPotential = jobList.get(position).getPotential();
        viewholder.deliveredOutlook = jobList.get(position).getOutlook();
        viewholder.deliveredEnvironment = jobList.get(position).getEnvironment();
        viewholder.deliveredRequiredAbility = jobList.get(position).getRequiredAbility();
        viewholder.deliveredKnowledge = jobList.get(position).getKnowledge();

    }

    @Override
    public int getItemCount() {

        return (null != jobList ? jobList.size() : 0);
    }

}
