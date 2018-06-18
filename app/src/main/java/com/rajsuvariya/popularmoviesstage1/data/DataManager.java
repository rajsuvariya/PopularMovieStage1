
package com.rajsuvariya.popularmoviesstage1.data;

import android.content.Context;

import com.rajsuvariya.popularmoviesstage1.data.local.AppDataBase;
import com.rajsuvariya.popularmoviesstage1.data.local.PreferencesHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.ApiHeader;
import com.rajsuvariya.popularmoviesstage1.data.remote.ApiHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.AppApiHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.Genre;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.PopularMovieResponseModel;
import com.rajsuvariya.popularmoviesstage1.injection.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Singleton
public class DataManager implements ApiHelper {

    private static final String TAG = "DataManager";

    private final PreferencesHelper mPreferencesHelper;
    private final AppApiHelper mApiHelper;
    private final AppDataBase mDb;

    @Inject
    public DataManager(PreferencesHelper preferencesHelper,
                       AppApiHelper apiHelper, @ApplicationContext Context applicationContext) {
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mDb = AppDataBase.getInstance(applicationContext);
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

    @Override
    public Observable<MovieDetailsOutputModel> getMovieDetails(int id) {
        return mApiHelper.getMovieDetails(id);
    }

    public MovieDetailsOutputModel getMovieDetailsfromDb(int id) {
        return mDb.favMovieDao().getMovieDetails(id);
    }

    public void addFavMovie(MovieDetailsOutputModel movie) {
        mDb.favMovieDao().insert(movie);
        for (Genre genre: movie.getGenres()){
            genre.setMovieId(movie.getId());
        }
        mDb.genreDao().saveGenresOfMovie(movie.getGenres());
    }

    public void removeFavMovie(MovieDetailsOutputModel movie) {
        mDb.favMovieDao().delete(movie);
    }

    public List<MovieDetailsOutputModel> getAllFavMovies() {
        List<MovieDetailsOutputModel> movieList = mDb.favMovieDao().getAllFavMovies();
        for (MovieDetailsOutputModel movie: movieList){
            movie.setGenres(mDb.genreDao().getGenresOfMovie(movie.getId()));
        }
        return movieList;
    }
}

