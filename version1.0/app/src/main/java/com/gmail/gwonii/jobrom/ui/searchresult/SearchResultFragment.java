package com.gmail.gwonii.jobrom.ui.searchresult;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.controller.AppHelper;
import com.gmail.gwonii.jobrom.controller.JobListAdapter;
import com.gmail.gwonii.jobrom.model.JobListModel;
import com.gmail.gwonii.jobrom.model.JobModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class SearchResultFragment extends Fragment implements JobListAdapter.OnListItemSelectedInterface {

    //
    public static String TAG = "search result jobList data read";

    // recyclerView 필요 변수 선언
    private ArrayList<JobModel> jobArrayList;
    private ArrayList<JobListModel> jobListModelArrayList;
    private JobListAdapter jobAdapter;
    private int count = 0;

    RecyclerView jobRecyclerView;


//    private Button moreButton;
    TextView totalJobNum;


    // recyclerView clickListener
    @Override
    public void onItemSelected(View v, int position) {
        JobListAdapter.JobListViewHolder viewHolder = (JobListAdapter.JobListViewHolder)jobRecyclerView.findViewHolderForAdapterPosition(position);
        Toast.makeText(getContext(), "전달되었습니다" + viewHolder.getName().getText(), Toast.LENGTH_SHORT).show();
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // inflate
        View root = inflater.inflate(R.layout.fragment_search_result, container, false);

        // view연결하기
//        moreButton = root.findViewById(R.id.bt_more);
        totalJobNum = root.findViewById(R.id.tv_total_job_num);


        // database 연결하기
        AppHelper.databaseJob = FirebaseDatabase.getInstance().getReference();

        // recyclerView 연결하기
        jobRecyclerView = root.findViewById(R.id.recycler_result_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this.getContext());
        jobRecyclerView.setLayoutManager(mLinearLayoutManager);

        // ArrayList 생성
        jobArrayList = new ArrayList<>();
        jobListModelArrayList = new ArrayList<>();

        //  Adapter 생성및 설정
        jobAdapter = new JobListAdapter(jobListModelArrayList, this);
        jobRecyclerView.setAdapter(jobAdapter);


        // 무슨 역할인지 모르겠다.  DiverItemDecoration ??
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(jobRecyclerView.getContext(),
//                mLinearLayoutManager.getOrientation());
//        jobRecyclerView.addItemDecoration(dividerItemDecoration);


        // database에서 가져온 데이터를 recyclerView에 넣어줘야 한다.

//        jobListModelArrayList.add(new JobListModel("축구선수", "민첩함,순발력,근육짱짱맨","2445만원"));
//        jobListModelArrayList.add(new JobListModel("프로그래머", "호권이 같은 실력자","4445만원"));
//        jobListModelArrayList.add(new JobListModel("디자이너", "호권이 같은 예술감각","5445만원"));
//        jobListModelArrayList.add(new JobListModel("야구선수", "민첩함,순발력,팔짱짱맨","4315만원"));
//        jobListModelArrayList.add(new JobListModel("야구선수", "민첩함,순발력,팔짱짱맨","4315만원"));
//        jobListModelArrayList.add(new JobListModel("야구선수", "민첩함,순발력,팔짱짱맨","4315만원"));
//        jobListModelArrayList.add(new JobListModel("야구선수", "민첩함,순발력,팔짱짱맨","4315만원"));


        // view 관련 기능

        // itemClicked





        // firebase에서 data 읽어오는 부분

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.child("total_jobs").getChildren()) {

                    if (count == 10) {
                        break;
                    } else {
                        JobModel jm = snapshot.getValue(JobModel.class);

                        if (jm != null) {
                            jobListModelArrayList.add(new JobListModel(jm.getName(), jm.getSummary(), jm.getSalary()));

                        }

                        Log.d(TAG, jobListModelArrayList.get(count).toString());

                        count++;
                    }


                }

                String total_num = "총 인원 "+ dataSnapshot.child("total_jobs").getChildrenCount();
                totalJobNum.setText(total_num);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        AppHelper.databaseJob.addValueEventListener(postListener);



        jobAdapter.notifyDataSetChanged();


        return root;
    }
}
