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
    private String ability;
    private String preparation;
    private String summary;
    private String salary;
    private String equality;
    private String potential;
    private String outlook;
    private String environment;
    private String requiredAbility;
    private String knowledge;

    private TextView tvName;
    private TextView tvDivision;
    private TextView tvAbility;
    private TextView tvPreparation;
    private TextView tvSummary;
    private TextView tvSalary;
    private TextView tvEquality;
    private TextView tvPotential;
    private TextView tvOutlook;
    private TextView tvEnvironment;
    private TextView tvRequiredAbility;
    private TextView tvKnowledge;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_job_detail, container, false);


        name = getArguments().getString("name");
        division = getArguments().getString("division");
        ability = getArguments().getString("ability");
        preparation = getArguments().getString("preparation");
        summary = getArguments().getString("summary");
        salary = getArguments().getString("salary");
        equality = getArguments().getString("equality");
        potential = getArguments().getString("potential");
        outlook = getArguments().getString("outlook");
        environment = getArguments().getString("environment");
        requiredAbility = getArguments().getString("requiredAbility");
        knowledge = getArguments().getString("knowledge");


        tvName = root.findViewById(R.id.tv_title);
        tvDivision = root.findViewById(R.id.tv_division);
        tvSalary = root.findViewById(R.id.tv_salary);

        tvEquality = root.findViewById(R.id.tv_equality);
        tvPotential = root.findViewById(R.id.tv_potential);
        tvOutlook = root.findViewById(R.id.tv_outlook);

        tvSummary = root.findViewById(R.id.tv_summary);
        tvEnvironment =root.findViewById(R.id.tv_environment);
        tvRequiredAbility = root.findViewById(R.id.tv_requred_ability);
        tvPreparation = root.findViewById(R.id.tv_preparation);

        tvName.setText(name);
        tvDivision.setText(division);
        tvSalary.setText(salary);

        tvEquality.setText(equality);
        tvPotential.setText(potential);
        tvOutlook.setText(outlook);

        tvSummary.setText(summary);
        tvEnvironment.setText(environment);
        tvRequiredAbility.setText(requiredAbility);
        tvPreparation.setText(preparation);

        Toast.makeText(getContext(), "자알 전달되었습니다" , Toast.LENGTH_SHORT).show();

        return root;
    }


}
