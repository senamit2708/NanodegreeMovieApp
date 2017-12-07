package com.example.senamit.nanodegreemovieapp;

import android.content.AsyncTaskLoader;
import android.content.Context;


import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by senamit on 2/12/17.
 */

public class MovieDetailsLoader extends AsyncTaskLoader<List<MovieDetails>> {

    String stringUrl;
    ArrayList<MovieDetails> movieDetailsArrayList = new ArrayList<>();





    public MovieDetailsLoader(Context context, String stringUrl) {
        super(context);
        this.stringUrl = stringUrl;
    }

    @Override
    protected void onStartLoading() {
        onForceLoad();
    }





    @Override
    public List<MovieDetails> loadInBackground() {


        try {
          movieDetailsArrayList =  QueryUtils.fetchMovieRequest(stringUrl);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movieDetailsArrayList;
    }
}
