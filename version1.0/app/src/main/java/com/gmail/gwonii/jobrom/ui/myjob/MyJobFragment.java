package com.gmail.gwonii.jobrom.ui.myjob;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.model.JobModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;


public class MyJobFragment extends Fragment {

    public static String TAG = "jobList data read";

    private MyJobViewModel myJobViewModel;
    private TextView textView;

    private EditText jobName;
    private EditText jobAbility;
    private EditText jobSalary;

    private ArrayList<JobModel> jobList;

    private DatabaseReference databaseJob;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myJobViewModel =
                ViewModelProviders.of(this).get(MyJobViewModel.class);
        View root = inflater.inflate(R.layout.fragment_myjob, container, false);

        databaseJob = FirebaseDatabase.getInstance().getReference();

        jobName = root.findViewById(R.id.et_job_name);
        jobAbility = root.findViewById(R.id.et_job_ability);
        jobSalary = root.findViewById(R.id.et_job_salery);

        Button enrollButton = root.findViewById(R.id.bt_enroll_job_data);

        myJobViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                readJobData();
                addJob();


            }

        });

        return root;
    }

    private void readJobData() {

        jobList = new ArrayList<>();
        Gson gson = new Gson();

        try {

            AssetManager am = getResources().getAssets();

            InputStream is = am.open("job_data.json");

            byte[] buffer = new byte[is.available()];

            is.read(buffer);

            is.close();

            String json = new String(buffer, "UTF-8");

            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonArray = jsonObject.getJSONArray("jobList");

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addJob() {

//        String name = jobName.getText().toString();
//        String ability = jobAbility.getText().toString();
//        String salary = jobSalary.getText().toString();


//            String id = databaseJob.push().getKey();

//            JobModel jobData = new JobModel(name, ability, salary);

        for (int i = 0; i < jobList.size(); i++) {

            databaseJob.child("jobs").child(Integer.toString(jobList.get(i).getJobId())).setValue(jobList.get(i));
        }

        Toast.makeText(this.getContext(), "added job", Toast.LENGTH_LONG).show();

    }

}
