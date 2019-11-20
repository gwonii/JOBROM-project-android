package com.gmail.gwonii.jobrom.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.ui.share.ShareFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;

    private MenuItem mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        // bottomNavigation 설정
//        setBottomNavigation();

        // searchbar 설정


    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        mSearch = menu.findItem(R.id.search);

        //메뉴 아이콘 클릭했을 시 확장, 취소했을 시 축소
        mSearch.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
//                TextView text = findViewById(R.id.txtstatus);
//                text.setText("현재 상태 : 확장됨");
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
//                TextView text=(TextView)findViewById(R.id.txtstatus);
//                text.setText("현재 상태 : 축소됨");
                return true;
            }
        });

        //menuItem을 이용해서 SearchView 변수 생성
        SearchView sv=(SearchView)mSearch.getActionView();
        //확인버튼 활성화
        sv.setSubmitButtonEnabled(true);

        //SearchView의 검색 이벤트
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //검색버튼을 눌렀을 경우
            @Override
            public boolean onQueryTextSubmit(String query) {
//                TextView text = (TextView)findViewById(R.id.txtresult);
//                text.setText(query + "를 검색합니다.");

                TextView text = findViewById(R.id.txtresult);

                Bundle bundle = new Bundle();
                bundle.putString("search_contents", text.getText().toString());
                navController.popBackStack();
                navController.navigate(R.id.nav_share, bundle);

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

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setBottomNavigation() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
