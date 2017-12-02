package com.example.senamit.nanodegreemovieapp;

import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<MovieDetails> movieDetailsArrayList = new ArrayList<MovieDetails>();
        movieDetailsArrayList.add(new MovieDetails("doOrDiew","26th nov"));
        movieDetailsArrayList.add(new MovieDetails("RestIsWaste","19th dec"));
        movieDetailsArrayList.add(new MovieDetails("ddfs","19th dec"));
        movieDetailsArrayList.add(new MovieDetails("amit","19th jan"));
        movieDetailsArrayList.add(new MovieDetails("dfasdgd","19th march"));


        MovieAdapter movieAdapter = new MovieAdapter(movieDetailsArrayList);

        recyclerView = findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(movieAdapter);



    }
}
