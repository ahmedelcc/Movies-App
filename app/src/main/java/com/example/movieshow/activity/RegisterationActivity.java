package com.example.movieshow.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.movieshow.R;
import com.example.movieshow.fragment.LoginFragment;
import com.example.movieshow.fragment.SignupFragment;

public class RegisterationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        attachFragments();
    }

    private void attachFragments() {
        LoginFragment loginFragment = new LoginFragment();
        SignupFragment signupFragment = new SignupFragment();

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_container, loginFragment);
        transaction.commit();
    }
}
