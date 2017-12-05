package com.example.senamit.nanodegreemovieapp;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by senamit on 2/12/17.
 */

public class MovieDetails {

    String movieName;
    String movieReleaseDate;
    String movieRating;
    String movieOverView;
    int movieImage;

//    public MovieDetails(String movieName, String movieReleaseDate, int movieImage) {
//        this.movieName = movieName;
//        this.movieReleaseDate = movieReleaseDate;
//        this.movieImage = movieImage;
//    }


    public MovieDetails(String movieName, String movieReleaseDate, String movieRating, String movieOverView, int movieImage) {
        this.movieName = movieName;
        this.movieReleaseDate = movieReleaseDate;
        this.movieRating = movieRating;
        this.movieOverView = movieOverView;
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public int getMovieImage() {
        return movieImage;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public String getMovieOverView() {
        return movieOverView;
    }
}
