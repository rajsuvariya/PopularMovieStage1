
package com.rajsuvariya.popularmoviesstage1.ui.movieListing;


import com.rajsuvariya.popularmoviesstage1.data.remote.model.PopularMovieResponseModel;
import com.rajsuvariya.popularmoviesstage1.ui.base.MvpView;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public interface MovieListMvpView extends MvpView {

    void populateMovieGrid(PopularMovieResponseModel popularMovieResponseModel);

    void appendMovieGrid(PopularMovieResponseModel popularMovieResponseModel);

    void showLoader(int visibility);
}
