package com.rajsuvariya.popularmoviesstage1.ui.movieDetails;

import android.util.Log;

import com.rajsuvariya.popularmoviesstage1.data.DataManager;
import com.rajsuvariya.popularmoviesstage1.data.local.AppDataBase;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;
import com.rajsuvariya.popularmoviesstage1.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by @raj on 05/06/18.
 */
public class MovieDetailsPresenter<V extends MovieDetailsMvpView> extends BasePresenter<V> implements MovieDetailsMvpPresenter<V> {

    private AppDataBase mDb;

    @Inject
    public MovieDetailsPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void init(int movieId) {
        fetchVideos(movieId);
    }

    @Override
    public void onFavClicked(MovieDetailsOutputModel movie) {
        MovieDetailsOutputModel movieExist = getDataManager().getMovieDetailsfromDb(movie.getId());
        if (movieExist == null) {
            getDataManager().addFavMovie(movie);
        } else {
            getDataManager().removeFavMovie(movie);
        }

        Log.d("RoomTest", getDataManager().getAllFavMovies().toString());
    }

    private void fetchVideos(Integer movieId) {
        if (getMvpView().isNetworkConnected()) {
            getCompositeDisposable().add(
                    getDataManager().getMovieDetails(movieId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<MovieDetailsOutputModel>() {
                                @Override
                                public void accept(MovieDetailsOutputModel movieDetailsOutputModel) throws Exception {
                                    getMvpView().populateUi(movieDetailsOutputModel);
                                    if (movieDetailsOutputModel.getVideos().getResults() != null && !movieDetailsOutputModel.getVideos().getResults().isEmpty())
                                        getMvpView().populateVideos(movieDetailsOutputModel.getVideos());
                                    else
                                        getMvpView().videosNotAvailable();
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    getMvpView().videosNotAvailable();
                                }
                            })
            );
        } else {
            getMvpView().videosNotAvailable();
        }
    }
}
