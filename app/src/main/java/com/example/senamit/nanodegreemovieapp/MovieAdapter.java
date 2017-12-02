package com.example.senamit.nanodegreemovieapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by senamit on 2/12/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String LOG_TAG = MovieAdapter.class.getSimpleName();

    TextView movieName;
    TextView movieReleaseDate;
    Context context;

    List<MovieDetails> movieDetailsList;


    //here constructor is called, so that whenever someone calls this adapter he has to provide the list which we will
    //use here in the class to inflate the recyclerview with that list
    public MovieAdapter(List<MovieDetails> movieDetailsList) {
        this.movieDetailsList = movieDetailsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details, parent, false);

        Log.i(LOG_TAG, "inside onCreateViewHolder method");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.i(LOG_TAG, "inside onBindViewHOlder starting point");
        //lets starting inserting data into the variables
        movieName.setText(movieDetailsList.get(position).getMovieName());
        movieReleaseDate.setText(movieDetailsList.get(position).getMovieReleaseDate());


    }

    @Override
    public int getItemCount() {
        return movieDetailsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {

            super(itemView);
            Log.i(LOG_TAG,"inside viewHolder constructor ");
            movieName= itemView.findViewById(R.id.txt_movie_name);
            movieReleaseDate= itemView.findViewById(R.id.txt_movieReleaseDate);
            context = itemView.getContext();


        }
    }

}
