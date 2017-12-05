package com.example.senamit.nanodegreemovieapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by senamit on 5/12/17.
 */

public class MovieDetailAdapter extends RecyclerView.Adapter<MovieDetailAdapter.ViewHolder> {

    public static final String LOG_TAG = MovieDetailAdapter.class.getSimpleName();



    Context context;


    List<MovieDetails> movieDetailsList;

    public MovieDetailAdapter(List<MovieDetails> movieDetailsList) {
        this.movieDetailsList = movieDetailsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.movieName.setText(movieDetailsList.get(position).getMovieName());
        holder.movieReleaseDate.setText(movieDetailsList.get(position).getMovieReleaseDate());
        holder.movieImage.setImageBitmap(movieDetailsList.get(position).getBitmap());
    }

    @Override
    public int getItemCount() {
        return movieDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView movieName;
        TextView movieReleaseDate;
        ImageView movieImage;

        public ViewHolder(View itemView) {
            super(itemView);

            Log.i(LOG_TAG,"inside viewHolder constructor ");
            movieName= (TextView) itemView.findViewById(R.id.txt_movie_name);
            movieReleaseDate= (TextView) itemView.findViewById(R.id.txt_movieReleaseDate);
            movieImage = (ImageView)itemView.findViewById(R.id.img_movieImage);
            context = itemView.getContext();

        }
    }
}