package com.rajsuvariya.popularmoviesstage1.ui.movieDetails;

import com.rajsuvariya.popularmoviesstage1.data.DataManager;
import com.rajsuvariya.popularmoviesstage1.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @raj on 05/06/18.
 */
public class MovieDetailsPresenter<V extends MovieDetailsMvpView> extends BasePresenter<V> implements MovieDetailsMvpPresenter<V>{

    @Inject
    public MovieDetailsPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }
}
