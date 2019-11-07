package com.example.movieshow.model;

import com.google.gson.annotations.SerializedName;

public class MovieModelData {
    private  String movieTitle;
    private String movieDescription;
    private String moviePhoto;
    private String movieYear;

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public String getMoviePhoto() {
       return "http://t2.gstatic.com/images?q=tbn:ANd9GcQW3LbpT94mtUG1PZIIzJNxmFX399wr_NcvoppJ82k7z99Hx6in";
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public void setMoviePhoto(String moviePhoto) {
        this.moviePhoto = moviePhoto;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }
}

