package com.rajsuvariya.popularmoviesstage1.ui.movieListing;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.rajsuvariya.popularmoviesstage1.R;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.PopularMovieResponseModel;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.Result;
import com.rajsuvariya.popularmoviesstage1.ui.base.BaseActivity;
import com.rajsuvariya.popularmoviesstage1.ui.movieDetails.MovieDetailsActivity;
import com.rajsuvariya.popularmoviesstage1.utils.DialogUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public class MovieListActivity extends BaseActivity implements MovieListMvpView, MovieListingAdapter.OnItemInteractionListener {

    @Inject
    MovieListMvpPresenter<MovieListMvpView> mPresenter;

    @BindView(R.id.rv_movie_grid)
    RecyclerView rvMovieGrid;

    @BindView(R.id.pb_loader)
    ProgressBar pbLoader;

    GridLayoutManager mLayoutManager;
    MovieListingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(MovieListActivity.this);

        mPresenter.init();
    }

    @Override
    public void populateMovieGrid(PopularMovieResponseModel popularMovieResponseModel) {
        mLayoutManager = new GridLayoutManager(this, 2);
        mAdapter = new MovieListingAdapter(popularMovieResponseModel.getResults(), this);

        rvMovieGrid.setLayoutManager(mLayoutManager);
        rvMovieGrid.setAdapter(mAdapter);

        rvMovieGrid.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mPresenter.onMovieListScrolled(dy, mLayoutManager.getChildCount(), mLayoutManager.getItemCount(), mLayoutManager.findFirstVisibleItemPosition(), mLayoutManager.findLastVisibleItemPosition());
            }
        });
    }

    @Override
    public void appendMovieGrid(PopularMovieResponseModel popularMovieResponseModel) {
        mAdapter.appendList(popularMovieResponseModel.getResults());
    }

    @Override
    public void showLoader(int visibility) {
        pbLoader.setVisibility(visibility);
    }

    @Override
    public void showInternetRetryDialog() {
        DialogUtils.dialogBoxWithButtons(this, "Internet Not Available!",
                "It seems like your internet is not working. Please check your connection and try again"
                , "Retry", "Cancel", false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mPresenter.fetchMovieList();
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
    }

    @Override
    public void showApiErrorRetryDialog() {
        DialogUtils.dialogBoxWithButtons(this, "Internet Not Available!",
                "It seems like your internet is not working. Please check your connection and try again"
                , "Retry", null, false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        mPresenter.fetchMovieList();
                    }
                }, null);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onItemClicked(Result itemData) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.ITEM_DATA, itemData);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_sort_popularity:
                mPresenter.sortByPopularitySelected();
                break;
            case R.id.action_sort_rating:
                mPresenter.sortByRatingSelected();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
