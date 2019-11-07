package com.example.movieshow.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieshow.R;

import com.example.movieshow.SessionManager;
import com.example.movieshow.adapter.HomeRvAdapter;
import com.example.movieshow.model.MovieModelData;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView homeRv;
    HomeRvAdapter adapter;
    SessionManager sessionManager;

    List<MovieModelData> movieslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUpRecycleView();

//navigation view
        drawerLayout = findViewById(R.id.drawer);

        navigationView = findViewById(R.id.nav_side_menu);

//display email from session
         sessionManager=new SessionManager(this);
        String email=sessionManager.getUserDetails().get(sessionManager.getUserDetails().get("email"));

       // View header = navigationView.getHeaderView(0);
       // TextView tvEmail=header.findViewById(R.id.tv_Name);

       // tvEmail.setText(email);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.action_profile:
                        Toast.makeText(HomeActivity.this, " profile", Toast.LENGTH_SHORT).show();
                        Intent intentPro=new Intent(HomeActivity.this,ProfileActivity.class);
                        startActivity(intentPro);
                        break;
                    case R.id.action_setting:
                        Toast.makeText(HomeActivity.this, " setting", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HomeActivity.this,SettingActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_help:
                        Toast.makeText(HomeActivity.this, " help", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_exit:
                        Toast.makeText(HomeActivity.this, " sign out", Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                        sessionManager.logoutUser();
                        startActivity(new Intent(getApplicationContext(),RegisterationActivity.class));
                        break;

                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean isLoggedIn = sessionManager.checkLogin();
        if (!isLoggedIn) {
            Intent intent = new Intent(HomeActivity.this, RegisterationActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpRecycleView() {
        homeRv = findViewById(R.id.rv_home);
        adapter = new HomeRvAdapter(HomeActivity.this);
        GridLayoutManager layoutManager = new GridLayoutManager(HomeActivity.this,2);
        homeRv.setItemAnimator(new DefaultItemAnimator());
        homeRv.setLayoutManager(layoutManager);
        homeRv.addItemDecoration(new DividerItemDecoration(homeRv.getContext(), layoutManager.getOrientation()));

        homeRv.setAdapter(adapter);

        List<MovieModelData> movies =new ArrayList<>();
        for(int i=0;i<25;i++){
           movies.add(new MovieModelData());

        }
        //
             adapter.setMovieList(movies);
    }
}
