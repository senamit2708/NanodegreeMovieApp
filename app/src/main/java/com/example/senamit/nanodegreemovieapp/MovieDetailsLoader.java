package com.example.senamit.nanodegreemovieapp;

import android.content.AsyncTaskLoader;
import android.content.Context;


import java.io.IOException;
import java.util.List;

/**
 * Created by senamit on 2/12/17.
 */

public class MovieDetailsLoader extends AsyncTaskLoader<List<MovieDetails>> {

    List<MovieDetails> movieDetailsList;

    public MovieDetailsLoader(Context context) {
        super(context);
    }
    public MovieDetailsLoader(Context context, List<MovieDetails> movieDetailsList){
        super(context);
      this.movieDetailsList =  movieDetailsList;
    }


    @Override
    protected void onStartLoading() {
        onForceLoad();
    }

    @Override
    public List<MovieDetails> loadInBackground() {
        try {
            QueryUtils.fetchMovieRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieDetailsList;
    }
}
