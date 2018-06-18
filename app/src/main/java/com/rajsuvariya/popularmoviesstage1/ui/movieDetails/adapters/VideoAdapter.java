package com.rajsuvariya.popularmoviesstage1.ui.movieDetails.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.rajsuvariya.popularmoviesstage1.R;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;
import com.rajsuvariya.popularmoviesstage1.utils.AppConstants;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by @raj on 09/06/18.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private VideoItemInteractionListener mListener;

    private final String TAG = VideoAdapter.class.getSimpleName();

    @NotNull
    private List<MovieDetailsOutputModel.Result> mVideoList = new ArrayList<>();

    public VideoAdapter(VideoItemInteractionListener mListener) {
        this.mListener = mListener;
    }

    public void setVideoList(List<MovieDetailsOutputModel.Result> mVideoList) {
        this.mVideoList = mVideoList;
        notifyDataSetChanged();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final VideoViewHolder holder, int position) {
        if (mVideoList.size() > position) {
            holder.pbLoading.setVisibility(View.GONE);
            holder.ivThumbnail.setVisibility(View.VISIBLE);
            Picasso.with(holder.itemView.getContext())
                    .load(AppConstants.YOUTUBE_THUMBNAIL_BASE_URL + mVideoList.get(position).getKey() + "/0.jpg")
                    .into(holder.ivThumbnail);
            Log.d(TAG, AppConstants.YOUTUBE_THUMBNAIL_BASE_URL + mVideoList.get(position).getKey() + "/0.jpg");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onVideoItemClicked(holder.getAdapterPosition(), mVideoList.get(holder.getAdapterPosition()).getKey());
                }
            });
        } else {
            holder.pbLoading.setVisibility(View.VISIBLE);
            holder.ivThumbnail.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(null);
        }
    }

    @Override
    public int getItemCount() {
        if (mVideoList.isEmpty()) {
            return 4;
        } else {
            return mVideoList.size();
        }
    }

    public interface VideoItemInteractionListener {

        void onVideoItemClicked(int position, String id);
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pb_loading)
        ProgressBar pbLoading;

        @BindView(R.id.iv_video_thumbnail)
        ImageView ivThumbnail;

        public VideoViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
