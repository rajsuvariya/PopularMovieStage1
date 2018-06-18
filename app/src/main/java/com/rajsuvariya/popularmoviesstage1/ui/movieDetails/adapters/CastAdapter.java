package com.rajsuvariya.popularmoviesstage1.ui.movieDetails.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajsuvariya.popularmoviesstage1.R;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;
import com.rajsuvariya.popularmoviesstage1.utils.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by @raj on 10/06/18.
 */
public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private List<MovieDetailsOutputModel.Cast> mCastList;
    private final String TAG = CastAdapter.class.getSimpleName();

    public CastAdapter(List<MovieDetailsOutputModel.Cast> mCastList) {
        this.mCastList = mCastList;
    }

    @Override
    public CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cast_profile, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CastViewHolder holder, int position) {
        holder.tvCastName.setText(mCastList.get(position).getName());
        Log.d(TAG, AppConstants.TMDB_IMAGE_BASE_URL_W500 + mCastList.get(position).getProfilePath());
        Picasso.with(holder.itemView.getContext())
                .load(AppConstants.TMDB_IMAGE_BASE_URL_W500 + mCastList.get(position).getProfilePath())
                .placeholder(R.drawable.ic_person)
                .into(holder.ivCastImageView);
    }

    @Override
    public int getItemCount() {
        return mCastList.size();
    }

    class CastViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_cast_image)
        ImageView ivCastImageView;

        @BindView(R.id.tv_cast_name)
        TextView tvCastName;

        CastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
