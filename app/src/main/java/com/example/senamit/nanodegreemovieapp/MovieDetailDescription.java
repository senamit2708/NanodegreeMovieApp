package com.example.senamit.nanodegreemovieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MovieDetailDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail_description);
        TextView txtMovieName = findViewById(R.id.txt_movie_name);
        MovieDetails movieDetails;
//        txtMovieName = movieDetails.getMovieName();
    }
}
