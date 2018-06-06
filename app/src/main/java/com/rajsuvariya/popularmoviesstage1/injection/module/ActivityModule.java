package com.rajsuvariya.popularmoviesstage1.injection.module;

import android.app.Activity;
import android.content.Context;


import com.rajsuvariya.popularmoviesstage1.injection.ActivityContext;
import com.rajsuvariya.popularmoviesstage1.injection.PerActivity;
import com.rajsuvariya.popularmoviesstage1.ui.movieDetails.MovieDetailsMvpPresenter;
import com.rajsuvariya.popularmoviesstage1.ui.movieDetails.MovieDetailsMvpView;
import com.rajsuvariya.popularmoviesstage1.ui.movieDetails.MovieDetailsPresenter;
import com.rajsuvariya.popularmoviesstage1.ui.movieListing.MovieListMvpPresenter;
import com.rajsuvariya.popularmoviesstage1.ui.movieListing.MovieListMvpView;
import com.rajsuvariya.popularmoviesstage1.ui.movieListing.MovieListPresenter;
import com.rajsuvariya.popularmoviesstage1.ui.splash.SplashMvpPresenter;
import com.rajsuvariya.popularmoviesstage1.ui.splash.SplashMvpView;
import com.rajsuvariya.popularmoviesstage1.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MovieListMvpPresenter<MovieListMvpView> provideMovieListPresenter(MovieListPresenter<MovieListMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MovieDetailsMvpPresenter<MovieDetailsMvpView> provideMovieDetailsPresenter(MovieDetailsPresenter<MovieDetailsMvpView> presenter) {
        return presenter;
    }
}
