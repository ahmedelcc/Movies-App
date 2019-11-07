package com.example.movieshow.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.movieshow.R;
import com.example.movieshow.SessionManager;
import com.google.firebase.auth.FirebaseAuth;

import java.security.AccessController;

public class ProfileActivity extends AppCompatActivity {
   TextView tvName;
   Context context;
   SessionManager sessionManager;
    private static final String PREF_NAME ="UserPref";
   String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvName=findViewById(R.id.tv_Name);
       // sessionManager=new SessionManager(getContext());
       // name = sessionManager.getUserDetails().get(PREF_NAME);
       tvName.setText("dfdfgdxgf");
    }
}
