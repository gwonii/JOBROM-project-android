package com.gmail.gwonii.jobrom.ui.jobdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.gmail.gwonii.jobrom.R;

import org.w3c.dom.Text;


public class JobDetailFragment extends Fragment  {

    private String name;
    private String division;
    private String salary;

    private TextView tvName;
    private TextView tvDivision;
    private TextView tvSalary;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_job_detail, container, false);


        name = getArguments().getString("name");
        division = getArguments().getString("division");
        salary = getArguments().getString("salary");

        tvName = root.findViewById(R.id.tv_job_title);
        tvDivision = root.findViewById(R.id.tv_job_division);

        tvName.setText(name);
        tvDivision.setText(division);

        Toast.makeText(getContext(), "자알 전달되었습니다" , Toast.LENGTH_SHORT).show();

        return root;
    }
}
