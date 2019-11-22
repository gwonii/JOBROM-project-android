package com.gmail.gwonii.jobrom.ui.search;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.controller.AppHelper;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    private TextView textView;

    private SearchView sv;
    private Button searchButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_search, container, false);

        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);

        searchViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        //searchView 변수 생성
        sv = root.findViewById(R.id.floating_search_view);

        //확인버튼 활성화
        sv.setSubmitButtonEnabled(true);

        //SearchView의 검색 이벤트
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //검색버튼을 눌렀을 경우
            @Override
            public boolean onQueryTextSubmit(String query) {
//                TextView text = (TextView)findViewById(R.id.txtresult);
//                text.setText(query + "를 검색합니다.");
//
//                TextView text = findViewById(R.id.txtresult);
//
//                Bundle bundle = new Bundle();
//                bundle.putString("search_contents", text.getText().toString());
//                navController.popBackStack();
//                navController.navigate(R.id.nav_share, bundle);



                return true;
            }

            //텍스트가 바뀔때마다 호출
            @Override
            public boolean onQueryTextChange(String newText) {
//                TextView text = (TextView)findViewById(R.id.txtsearch);
//                text.setText("검색식 : "+newText);



                return true;
            }
        });


        searchButton = root.findViewById(R.id.bt_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                AppHelper.navController.popBackStack();
                AppHelper.navController.navigate(R.id.nav_search_result);

            }
        });

//        Bundle bundle = new Bundle();
//        bundle.putString("search_contents", text.getText().toString());
//
//        AppHelper.navController.popBackStack();
//        AppHelper.navController.navigate(R.id.nav_share, bundle);




        return root;
    }
}
