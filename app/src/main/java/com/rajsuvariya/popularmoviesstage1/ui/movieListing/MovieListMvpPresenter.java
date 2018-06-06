package com.rajsuvariya.popularmoviesstage1.ui.movieListing;


import com.rajsuvariya.popularmoviesstage1.injection.PerActivity;
import com.rajsuvariya.popularmoviesstage1.ui.base.MvpPresenter;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@PerActivity
public interface MovieListMvpPresenter<V extends MovieListMvpView> extends MvpPresenter<V> {

    void init();

    void onMovieListScrolled(int dy, int visibleItemCount, int totalItemCount, int pastVisibleItems, int lastVisibleItem);

    void sortByPopularitySelected();

    void sortByRatingSelected();
}
