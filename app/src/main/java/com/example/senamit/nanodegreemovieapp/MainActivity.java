package com.example.senamit.nanodegreemovieapp;


import android.app.LoaderManager;
import android.content.Loader;
import android.net.Uri;
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
    EndlessRecycleOnScrollListener endlessRecycleOnScrollListener;
    int count =0;
    int pageNumber=1;
    String string1= "https://api.themoviedb.org/3/discover/movie?page=";
    String string2 = "&include_video=false&include_adult=false&sort_by=popularity.desc&language=en-US&api_key=f6fc8d8e4043fefdfe43c153dd429479";

    public static String stringUrl = "https://api.themoviedb.org/3/discover/movie?page=1&include_video=false&include_adult=false&sort_by=popularity.desc&language=en-US&api_key=f6fc8d8e4043fefdfe43c153dd429479";


    List<MovieDetails> arrayList= new ArrayList<>();
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        endlessRecycleOnScrollListener = new EndlessRecycleOnScrollListener() {

            @Override
            public void mLoadMore() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder = stringBuilder.append(string1).append(pageNumber).append(string2);
                Log.i(LOG_TAG,"the string builder is "+stringBuilder);
                Log.i(LOG_TAG, "the page number is  "+pageNumber);
                stringUrl = stringBuilder.toString();

                getLoaderManager().initLoader(pageNumber, savedInstanceState,MainActivity.this);

            }


        };
        recyclerView.addOnScrollListener(endlessRecycleOnScrollListener);

        getLoaderManager().initLoader(0, savedInstanceState,this);

    }

    @Override
    public Loader<List<MovieDetails>> onCreateLoader(int i, Bundle bundle) {
        Log.i(LOG_TAG, "inside oncreateloader");


        return new MovieDetailsLoader(this, stringUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<MovieDetails>> loader, List<MovieDetails> movieDetailsList) {
        Log.i(LOG_TAG,"inside onLoadFinished mehtod");
        Log.i(LOG_TAG,"total no of items before in class object"+ arrayList.size());
        arrayList.addAll(movieDetailsList);
        movieDetailAdapter = new MovieDetailAdapter(arrayList);
        recyclerView.setAdapter(movieDetailAdapter);
        pageNumber++;
        Log.i(LOG_TAG,"total no of items after in class object"+ arrayList.size());
        Log.i(LOG_TAG, "the page number is "+pageNumber);
        Log.i(LOG_TAG, "the total number o item in adapter is "+ movieDetailAdapter.getItemCount());
    }

    @Override
    public void onLoaderReset(Loader<List<MovieDetails>> loader) {

        movieDetailAdapter  =  new MovieDetailAdapter(new ArrayList<MovieDetails>());
        Log.i(LOG_TAG, "inside reset");

    }




}
