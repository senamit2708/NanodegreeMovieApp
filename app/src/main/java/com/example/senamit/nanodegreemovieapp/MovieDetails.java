package com.example.senamit.nanodegreemovieapp;

/**
 * Created by senamit on 2/12/17.
 */

public class MovieDetails {

    String movieName;
    String movieReleaseDate;

    public MovieDetails(String movieName, String movieReleaseDate) {
        this.movieName = movieName;
        this.movieReleaseDate = movieReleaseDate;
    }


    public String getMovieName() {
        return movieName;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }
}
