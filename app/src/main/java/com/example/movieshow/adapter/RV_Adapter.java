package com.example.movieshow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieshow.R;
import com.example.movieshow.model.MovieModelData;

import java.util.List;

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.StudentViewHolder> {
    private Context context;
    private List<MovieModelData> studentdata;

    public RV_Adapter(Context context, List<MovieModelData> studentdata) {
        this.context = context;
        this.studentdata = studentdata;
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rv_items,parent,false);

        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {
        MovieModelData model=studentdata.get(position);
       // holder.tvName.setText(model.getUserName());
      //  holder.tvAge.setText(model.getUserUrl());

    }


    @Override
    public int getItemCount() {
        return studentdata.size();
    }
    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAge;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_item);
            tvAge=itemView.findViewById(R.id.tv_age);
        }
    }
}

