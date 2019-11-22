package com.gmail.gwonii.jobrom.ui.searchresult;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.controller.JobListAdapter;
import com.gmail.gwonii.jobrom.model.JobModel;

import java.util.ArrayList;


public class SearchResultFragment extends Fragment {


    // recyclerView 필요 변수 선언
    private ArrayList<JobModel> jobArrayList;
    private JobListAdapter jobAdapter;
    private int count = -1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // inflate
        View root = inflater.inflate(R.layout.fragment_search_result, container, false);

        // recyclerView 연결하기
        RecyclerView jobRecyclerView = root.findViewById(R.id.recycler_result_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this.getContext());
        jobRecyclerView.setLayoutManager(mLinearLayoutManager);

        // ArrayList 생성
        jobArrayList = new ArrayList<>();

        //  Adapter 생성및 설정
        jobAdapter = new JobListAdapter(jobArrayList);
        jobRecyclerView.setAdapter(jobAdapter);


        // 무슨 역할인지 모르겠다.  DiverItemDecoration ??
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(jobRecyclerView.getContext(),
//                mLinearLayoutManager.getOrientation());
//        jobRecyclerView.addItemDecoration(dividerItemDecoration);


        // database에서 가져온 데이터를 recyclerView에 넣어줘야 한다.

        jobArrayList.add(new JobModel("축구선수", "민첩함,순발력,근육짱짱맨","2445만원"));
        jobArrayList.add(new JobModel("프로그래머", "호권이 같은 실력자","4445만원"));
        jobArrayList.add(new JobModel("디자이너", "호권이 같은 예술감각","5445만원"));
        jobArrayList.add(new JobModel("야구선수", "민첩함,순발력,팔짱짱맨","4315만원"));
        jobArrayList.add(new JobModel("야구선수", "민첩함,순발력,팔짱짱맨","4315만원"));
        jobArrayList.add(new JobModel("야구선수", "민첩함,순발력,팔짱짱맨","4315만원"));
        jobArrayList.add(new JobModel("야구선수", "민첩함,순발력,팔짱짱맨","4315만원"));

        jobAdapter.notifyDataSetChanged();

        return root;
    }
}
