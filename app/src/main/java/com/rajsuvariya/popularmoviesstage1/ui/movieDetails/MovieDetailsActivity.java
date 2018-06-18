package com.rajsuvariya.popularmoviesstage1.ui.movieDetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rajsuvariya.popularmoviesstage1.R;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.Genre;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;
import com.rajsuvariya.popularmoviesstage1.ui.base.BaseActivity;
import com.rajsuvariya.popularmoviesstage1.ui.movieDetails.adapters.CastAdapter;
import com.rajsuvariya.popularmoviesstage1.ui.movieDetails.adapters.VideoAdapter;
import com.rajsuvariya.popularmoviesstage1.utils.AppConstants;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends BaseActivity implements MovieDetailsMvpView, VideoAdapter.VideoItemInteractionListener {

    public static final String MOVIE_ID = "_item_data";

    @Inject
    MovieDetailsMvpPresenter<MovieDetailsMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.iv_banner)
    ImageView ivBanner;

    @BindView(R.id.iv_movie_poster)
    ImageView ivPoster;

    @BindView(R.id.tv_released_on)
    TextView tvReleasedOn;

    @BindView(R.id.tv_rating)
    TextView tvRating;

    @BindView(R.id.rb_rating)
    RatingBar rbRatingBar;

    @BindView(R.id.tv_storyline)
    TextView tvStoryline;

    @BindView(R.id.tv_language)
    TextView tvLanguage;

    @BindView(R.id.rv_videos)
    RecyclerView rvVideos;

    @BindView(R.id.tv_videos_error)
    TextView tvVideoError;

    @BindView(R.id.pb_movie_detail_loader)
    ProgressBar pbMovieDetailLoader;

    @BindView(R.id.container_movie_details_content)
    ConstraintLayout containerMovieDetailsContent;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout ctlToolbar;

    @BindView(R.id.rv_cast)
    RecyclerView rvCast;

    @BindView(R.id.tv_genres)
    TextView tvGenres;

    int movieId;
    VideoAdapter mVideoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        setSupportActionBar(toolbar);
        setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        movieId = getIntent().getIntExtra(MOVIE_ID, -1);
        mPresenter.init(movieId);
    }

    @Override
    public void populateUi(final MovieDetailsOutputModel movieDetailsOutputModel) {

        pbMovieDetailLoader.setVisibility(View.GONE);
        containerMovieDetailsContent.setVisibility(View.VISIBLE);
//        getSupportActionBar().setTitle(movieDetailsOutputModel.getOriginalTitle());
//        toolbar.setTitle(movieDetailsOutputModel.getOriginalTitle());
//        setTitle(movieDetailsOutputModel.getOriginalTitle());
        ctlToolbar.setTitle(movieDetailsOutputModel.getOriginalTitle());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onFavClicked(movieDetailsOutputModel);
                Snackbar.make(view, "Action will be available soon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Picasso.with(this)
                .load(AppConstants.TMDB_IMAGE_BASE_URL_W500 + movieDetailsOutputModel.getBackdropPath())
                .into(ivBanner);

        Picasso.with(this)
                .load(AppConstants.TMDB_IMAGE_BASE_URL_W500 + movieDetailsOutputModel.getPosterPath())
                .into(ivPoster);


        tvRating.setText(String.format("%s/5", String.valueOf(movieDetailsOutputModel.getVoteAverage() / 2)));
        rbRatingBar.setNumStars(5);
        rbRatingBar.setRating((float) (movieDetailsOutputModel.getVoteAverage() / 2));
        tvReleasedOn.setText(movieDetailsOutputModel.getReleaseDate());
        tvStoryline.setText(movieDetailsOutputModel.getOverview());
        tvLanguage.setText(movieDetailsOutputModel.getOriginalLanguage());

        mVideoAdapter = new VideoAdapter(this);
        rvVideos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvVideos.setAdapter(mVideoAdapter);

        CastAdapter mCastAdapter;
        mCastAdapter = new CastAdapter(movieDetailsOutputModel.getCredits().getCast());
        rvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvCast.setAdapter(mCastAdapter);


        StringBuilder genresString = new StringBuilder();
        for (Genre genre : movieDetailsOutputModel.getGenres()) {
            genresString.append(genre.getName()).append(", ");
        }
        if (genresString.indexOf(",") > 0) {
            tvGenres.setText(genresString.substring(0, genresString.length() - 2));
        } else {
            tvGenres.setText(R.string.details_not_available);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void videosNotAvailable() {
        rvVideos.setVisibility(View.GONE);
        tvVideoError.setVisibility(View.VISIBLE);
    }

    @Override
    public void populateVideos(MovieDetailsOutputModel.Videos movieVideoOuputModel) {
        mVideoAdapter.setVideoList(movieVideoOuputModel.getResults());
    }

    @Override
    public void onVideoItemClicked(int position, String id) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + id));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
