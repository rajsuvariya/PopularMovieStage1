
package com.rajsuvariya.popularmoviesstage1.data.remote;

import com.rajsuvariya.popularmoviesstage1.data.remote.model.PopularMovieResponseModel;

import io.reactivex.Observable;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<PopularMovieResponseModel> getPopularMovies(int pageNumber);

    Observable<PopularMovieResponseModel> getTopRatedMovies(int pageNumber);
}
