package com.rajsuvariya.popularmoviesstage1.ui.movieDetails;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rajsuvariya.popularmoviesstage1.R;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.Result;
import com.rajsuvariya.popularmoviesstage1.ui.base.BaseActivity;
import com.rajsuvariya.popularmoviesstage1.ui.movieListing.MovieListActivity;
import com.rajsuvariya.popularmoviesstage1.ui.movieListing.MovieListMvpPresenter;
import com.rajsuvariya.popularmoviesstage1.ui.movieListing.MovieListMvpView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends BaseActivity implements MovieDetailsMvpView {

    public static final String ITEM_DATA = "_item_data";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setUpUi();
    }

    private void setUpUi() {
        Result itemData = getIntent().getParcelableExtra(ITEM_DATA);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Action will be available soon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Picasso.with(this)
                .load("https://image.tmdb.org/t/p/w500" + itemData.getBackdropPath())
                .into(ivBanner);

        Picasso.with(this)
                .load("https://image.tmdb.org/t/p/w500" + itemData.getPosterPath())
                .into(ivPoster);

        setTitle(itemData.getOriginalTitle());

        tvRating.setText(String.format("%s/5", String.valueOf(itemData.getVoteAverage() / 2)));
        rbRatingBar.setNumStars(5);
        rbRatingBar.setRating(itemData.getVoteAverage() / 2);
        tvReleasedOn.setText(itemData.getReleaseDate());
        tvStoryline.setText(itemData.getOverview());
        tvLanguage.setText(itemData.getOriginalLanguage());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
