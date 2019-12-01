package com.gmail.gwonii.jobrom.ui.myjob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.controller.MainActivity;

public class MyJobFragment extends Fragment {

    private TextView tvUserEmail;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_myjob, container, false);

        tvUserEmail = root.findViewById(R.id.myjob_user_email);

        tvUserEmail.setText(MainActivity.userEmail);


        return root;
    }

}
