package com.example.senamit.nanodegreemovieapp;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by senamit on 6/12/17.
 */

public abstract class EndlessRecycleOnScrollListener extends RecyclerView.OnScrollListener {

    public static final String LOG_TAG = EndlessRecycleOnScrollListener.class.getSimpleName();
    GridLayoutManager gridLayoutManager;
    int visibleThreshold = 6;

    int mPreviousTotal = 0;
    boolean mLoading = true;

//    public EndlessRecycleOnScrollListener(GridLayoutManager gridLayoutManager) {
//        this.gridLayoutManager = gridLayoutManager;
//        Log.i(LOG_TAG, "inside the constructor of EndlessRecyser listener");
//
//    }


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = recyclerView.getChildCount();
        Log.i(LOG_TAG, "the value of visible item count is  "+ visibleItemCount);
        int totalItemCount = recyclerView.getLayoutManager().getItemCount();
        Log.i(LOG_TAG, "the value of total item count is  "+totalItemCount);
        int firstVisiblItemPosition = ((GridLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        Log.i(LOG_TAG, "the firstvisibleItemPosition is  "+firstVisiblItemPosition);

        if (mLoading){
            if (totalItemCount> mPreviousTotal){
                mLoading= false;
                Log.i(LOG_TAG, "the value of total item count is  "+ totalItemCount);
                Log.i(LOG_TAG, "the value of previous total is  "+mPreviousTotal);
                mPreviousTotal=totalItemCount;
            }
        }

//        if (!mLoading && (totalItemCount-visibleItemCount)<= (firstVisiblItemPosition+visibleThreshold)){
if(!mLoading && (totalItemCount==(firstVisiblItemPosition+4))){
            Log.i(LOG_TAG, "inside the mloadmore method call");

            mLoadMore();
            mLoading = true;
        }




    }
    public abstract void mLoadMore();
}



