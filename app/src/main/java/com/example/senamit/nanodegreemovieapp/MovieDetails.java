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
    String movieImageUrl;
//    int movieImage;
    Bitmap bitmap;

//    public MovieDetails(String movieName, String movieReleaseDate, int movieImage) {
//        this.movieName = movieName;
//        this.movieReleaseDate = movieReleaseDate;
//        this.movieImage = movieImage;
//    }


//    public MovieDetails(String movieName, String movieReleaseDate, String movieRating, String movieOverView, int movieImage) {
//        this.movieName = movieName;
//        this.movieReleaseDate = movieReleaseDate;
//        this.movieRating = movieRating;
//        this.movieOverView = movieOverView;
//        this.movieImage = movieImage;
//    }


    public MovieDetails(String movieName, String movieReleaseDate, String movieRating, String movieOverView, Bitmap bitmap) {
        this.movieName = movieName;
        this.movieReleaseDate = movieReleaseDate;
        this.movieRating = movieRating;
        this.movieOverView = movieOverView;
        this.bitmap = bitmap;
    }

    public MovieDetails(String movieName, String movieReleaseDate, String movieRating, String movieOverView, String movieImageUrl) {
        this.movieName = movieName;
        this.movieReleaseDate = movieReleaseDate;
        this.movieRating = movieRating;
        this.movieOverView = movieOverView;
        this.movieImageUrl = movieImageUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public String getMovieOverView() {
        return movieOverView;
    }

    public String getMovieImageUrl() {
        return movieImageUrl;
    }
}
