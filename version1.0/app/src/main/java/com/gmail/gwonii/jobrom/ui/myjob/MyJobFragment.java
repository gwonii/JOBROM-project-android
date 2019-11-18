package com.gmail.gwonii.jobrom.ui.myjob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.gmail.gwonii.jobrom.R;

public class MyJobFragment extends Fragment {

    private MyJobViewModel myJobViewModel;
    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myJobViewModel =
                ViewModelProviders.of(this).get(MyJobViewModel.class);
        View root = inflater.inflate(R.layout.fragment_myjob, container, false);


        //        textView = root.findViewById(R.id.text_home);

        myJobViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

}