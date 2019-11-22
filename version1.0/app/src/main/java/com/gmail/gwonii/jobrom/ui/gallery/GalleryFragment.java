package com.gmail.gwonii.jobrom.ui.gallery;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.controller.AppHelper;
import com.gmail.gwonii.jobrom.model.JobModel;
import com.gmail.gwonii.jobrom.ui.myjob.MyJobViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    public static String TAG = "jobList data read";

    private DatabaseReference databaseJob;

    private MyJobViewModel myJobViewModel;

    private ArrayList<JobModel> jobList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        AppHelper.databaseJob = FirebaseDatabase.getInstance().getReference();

        return root;
    }

    private void readJobData() {

        jobList = new ArrayList<>();
        Gson gson = new Gson();

        try {

            AssetManager am = getResources().getAssets();

            InputStream is = am.open("total_job_data.json");

            byte[] buffer = new byte[is.available()];

            is.read(buffer);


            String json = new String(buffer, "UTF-8");

            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonArray = jsonObject.getJSONArray("total_job_data");

            int index = 0;

            while (index < jsonArray.length()) {

                JobModel jobModel = gson.fromJson(jsonArray.get(index).toString(), JobModel.class);
                jobModel.setJobId(index);

                jobList.add(jobModel);
                index++;
            }


            for (int i = 0; i < jobList.size(); i++) {
                Log.d(TAG, jobList.get(i).toString());
            }

            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addJob() {


        for (int i = 0; i < jobList.size(); i++) {

            databaseJob.child("total_jobs").child(Integer.toString(jobList.get(i).getJobId())).setValue(jobList.get(i));
        }

        Toast.makeText(this.getContext(), "added job", Toast.LENGTH_LONG).show();

    }

}

