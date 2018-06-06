
package com.rajsuvariya.popularmoviesstage1.data;

import com.rajsuvariya.popularmoviesstage1.data.local.PreferencesHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.ApiHeader;
import com.rajsuvariya.popularmoviesstage1.data.remote.ApiHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.AppApiHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.PopularMovieResponseModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Singleton
public class DataManager implements ApiHelper{

    private static final String TAG = "DataManager";

    private final PreferencesHelper mPreferencesHelper;
    private final AppApiHelper mApiHelper;

    @Inject
    public DataManager(PreferencesHelper preferencesHelper,
                       AppApiHelper apiHelper) {
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }


    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Observable<PopularMovieResponseModel> getPopularMovies(int pageNumber) {
        return mApiHelper.getPopularMovies(pageNumber);
    }

    @Override
    public Observable<PopularMovieResponseModel> getTopRatedMovies(int pageNumber) {
        return mApiHelper.getTopRatedMovies(pageNumber);
    }
}
