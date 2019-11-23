package com.gmail.gwonii.jobrom.ui.jobdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.controller.JobListAdapter;


public class JobDetailFragment extends Fragment  {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_job_detail, container, false);



        return root;
    }
}
