package com.example.movieshow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieshow.R;
import com.example.movieshow.model.MovieModelData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeRvAdapter extends RecyclerView.Adapter<HomeRvAdapter.MovieViewHolder> {



    private Context context;
   private List<MovieModelData>moviesList;
    private LayoutInflater mInflater;

    public HomeRvAdapter(Context context){
        this.context=context;
        this.moviesList=new ArrayList<>();
        this.mInflater =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.movie_rv_items,parent,false);
        return new MovieViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModelData movie=moviesList.get(position);
        // This is how we use Picasso to load images from the internet.
        Picasso.with(context)
                .load(movie.getMoviePhoto())
                .placeholder(R.color.colorAccent)
                .into(holder.imageView);

        // holder.ivPhoto.s

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MovieViewHolder  extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public MovieViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public void setMovieList(List<MovieModelData> movieList)
    {
        this.moviesList.clear();
        this.moviesList.addAll(movieList);
        // The adapter needs to know that the data has changed. If we don't call this, app will crash.
        notifyDataSetChanged();
    }
}
