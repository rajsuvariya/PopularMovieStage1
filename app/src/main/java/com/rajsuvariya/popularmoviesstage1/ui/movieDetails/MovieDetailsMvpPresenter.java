package com.rajsuvariya.popularmoviesstage1.ui.movieDetails;

import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;
import com.rajsuvariya.popularmoviesstage1.ui.base.MvpPresenter;

/**
 * Created by @raj on 05/06/18.
 */
public interface MovieDetailsMvpPresenter<V extends MovieDetailsMvpView> extends MvpPresenter<V> {
    void init(int movieId);

    void onFavClicked(MovieDetailsOutputModel movie);
}
