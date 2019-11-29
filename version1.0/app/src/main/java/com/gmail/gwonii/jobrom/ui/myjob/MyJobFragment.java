package com.gmail.gwonii.jobrom.ui.myjob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.controller.AppHelper;

public class MyJobFragment extends Fragment {

    private Button button;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_myjob, container, false);


//        button = root.findViewById(R.id.bt_enroll_job_data);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppHelper.navController.navigate(R.id.nav_job_detail);
//
//            }
//        });



        return root;
    }

}
