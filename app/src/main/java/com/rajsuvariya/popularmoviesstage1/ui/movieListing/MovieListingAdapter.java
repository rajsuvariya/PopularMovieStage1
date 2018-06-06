package com.rajsuvariya.popularmoviesstage1.ui.movieListing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rajsuvariya.popularmoviesstage1.R;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by @raj on 03/06/18.
 */
public class MovieListingAdapter extends RecyclerView.Adapter<MovieListingAdapter.MovieListingViewHolder> {

    private List<Result> mList;
    private OnItemInteractionListener mListener;

    public MovieListingAdapter(List<Result> movieResultList, OnItemInteractionListener listener) {
        this.mList = movieResultList;
        this.mListener = listener;
    }

    @Override
    public MovieListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_listing, parent, false);
        return new MovieListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListingViewHolder holder, int position) {
        holder.bindData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void appendList(List<Result> results) {
        mList.addAll(results);
        notifyItemRangeInserted((mList.size() - results.size()) + 1, results.size());
    }

    interface OnItemInteractionListener {
        void onItemClicked(Result itemData);
    }

    class MovieListingViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_movie_poster)
        ImageView ivMoviePoster;

        MovieListingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(final Result result) {
            Picasso.with(itemView.getContext()).load("https://image.tmdb.org/t/p/w342" + result.getPosterPath()).into(ivMoviePoster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(result);
                }
            });
        }
    }
}
