package com.gmail.gwonii.jobrom.ui.gallery;


import android.os.Bundle;
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
import com.gmail.gwonii.jobrom.model.JobModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    private EditText jobName;
    private EditText jobAbility;
    private EditText jobSalery;
    private Button enrollButton;

    private DatabaseReference databaseJob;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        databaseJob = FirebaseDatabase.getInstance().getReference();

        jobName = root.findViewById(R.id.et_job_name);
        jobAbility = root.findViewById(R.id.et_job_ability);
        jobSalery = root.findViewById(R.id.et_job_salery);

        enrollButton = root.findViewById(R.id.bt_enroll_data);

        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });


        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addJob();
            }
        });

        return root;
    }

    private void addJob() {
        String name = jobName.getText().toString();
        String ability = jobAbility.getText().toString();
        String salery = jobSalery.getText().toString();

        if (!name.isEmpty() && !ability.isEmpty() && !salery.isEmpty()) {

//            String id = databaseJob.push().getKey();

            JobModel jobData = new JobModel(name, ability, salery);

            databaseJob.child("jobs").child(Integer.toString(jobData.getJobId())).setValue(jobData);


            Toast.makeText(this.getContext(), "added job", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this.getContext(), "please input data", Toast.LENGTH_LONG).show();
        }
    }
}

