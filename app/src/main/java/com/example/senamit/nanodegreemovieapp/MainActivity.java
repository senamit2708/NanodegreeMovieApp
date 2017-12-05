package com.example.senamit.nanodegreemovieapp;


import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<MovieDetails>> {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    RecyclerView recyclerView;
    MovieDetailAdapter  movieDetailAdapter;

    public static String stringUrl = "https://api.themoviedb.org/3/discover/movie?page=4&include_video=false&include_adult=false&sort_by=popularity.desc&language=en-US&api_key=f6fc8d8e4043fefdfe43c153dd429479";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        recyclerView = findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);



        getLoaderManager().initLoader(0, null,this);

    }

    @Override
    public Loader<List<MovieDetails>> onCreateLoader(int i, Bundle bundle) {
        Log.i(LOG_TAG, "inside oncreateloader");
//        return new MovieDetailsLoader(this, movieDetailsArrayList);
        return new MovieDetailsLoader(this, stringUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<MovieDetails>> loader, List<MovieDetails> movieDetailsList) {
        Log.i(LOG_TAG,"inside onLoadFinished mehtod");
     movieDetailAdapter = new MovieDetailAdapter(movieDetailsList);
        recyclerView.setAdapter(movieDetailAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<MovieDetails>> loader) {

        movieDetailAdapter  =  new MovieDetailAdapter(new ArrayList<MovieDetails>());
//        movieAdapter = new MovieAdapter();
    }




}
