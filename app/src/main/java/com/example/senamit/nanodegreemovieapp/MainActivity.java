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
    ArrayList<MovieDetails> movieDetailsArrayList;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        movieDetailsArrayList = new ArrayList<MovieDetails>();
        movieDetailsArrayList.add(new MovieDetails("doOrDiew","26th nov", R.drawable.testimage1));
        movieDetailsArrayList.add(new MovieDetails("RestIsWaste","19th dec",R.drawable.testimage1));
        movieDetailsArrayList.add(new MovieDetails("ddfs","19th dec",R.drawable.testimage1));
        movieDetailsArrayList.add(new MovieDetails("amit","19th jan",R.drawable.testimage1));
        movieDetailsArrayList.add(new MovieDetails("dfasdgd","19th march",R.drawable.testimage1));




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
        return new MovieDetailsLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<MovieDetails>> loader, List<MovieDetails> movieDetailsList) {
        Log.i(LOG_TAG,"inside onLoadFinished mehtod");
        movieAdapter = new MovieAdapter(movieDetailsList);
        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<MovieDetails>> loader) {

       movieAdapter =  new MovieAdapter(new ArrayList<MovieDetails>());
    }


//    @Override
//    public <List<MovieDetails>> onCreateLoader(int i, Bundle bundle) {
//        return new MovieDetailsLoader(this, movieDetailsArrayList);
//    }
//
//    @Override
//    public void onLoadFinished(android.content.Loader<List<MovieDetails>> loader, List<MovieDetails> movieDetails) {
//        movieAdapter = new MovieAdapter(movieDetailsArrayList);
//        recyclerView.setAdapter(movieAdapter);
//    }
//
//    @Override
//    public void onLoaderReset(android.content.Loader<List<MovieDetails>> loader) {
//
//    }


}
