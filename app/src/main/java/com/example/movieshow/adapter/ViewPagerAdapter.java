package com.example.movieshow.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieshow.fragment.LoginFragment;
import com.example.movieshow.fragment.Setting1;
import com.example.movieshow.fragment.Setting2;
import com.example.movieshow.fragment.Setting3;
import com.example.movieshow.fragment.SignupFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new Setting1();
            case 1:
                return new Setting2();
            case 2:
                return new Setting3();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Setting1";
            case 1:
                return "Setting2";
            case 2:
                return "Setting3";

        }
        return super.getPageTitle(position);
    }
}
