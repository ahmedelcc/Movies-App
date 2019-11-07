package com.example.movieshow.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieshow.R;
import com.example.movieshow.adapter.RV_Adapter;
import com.example.movieshow.model.MovieModelData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Setting1 extends Fragment {

    private RecyclerView StudentRv;
    private RV_Adapter rvAdapter;
    private ArrayList<MovieModelData> movieModel;

    public Setting1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting1, container, false);
        StudentRv =view.findViewById(R.id.RV_student);
        movieModel =new ArrayList<>();

        return view;

    }
    private void SetUpRV() {
        rvAdapter =new RV_Adapter(getContext(),movieModel);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        StudentRv.setLayoutManager(layoutManager);
        StudentRv.setAdapter(rvAdapter);
    }

}
