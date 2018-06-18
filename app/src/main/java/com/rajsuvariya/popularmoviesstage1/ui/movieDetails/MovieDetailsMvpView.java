package com.rajsuvariya.popularmoviesstage1.ui.movieDetails;

import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;
import com.rajsuvariya.popularmoviesstage1.ui.base.MvpView;

/**
 * Created by @raj on 05/06/18.
 */
public interface MovieDetailsMvpView extends MvpView {
    void videosNotAvailable();

    void populateVideos(MovieDetailsOutputModel.Videos movieVideoOuputModel);

    void populateUi(MovieDetailsOutputModel movieDetailsOutputModel);
}
