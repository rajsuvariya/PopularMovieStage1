

package com.rajsuvariya.popularmoviesstage1.ui.movieListing;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rajsuvariya.popularmoviesstage1.data.DataManager;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.PopularMovieResponseModel;
import com.rajsuvariya.popularmoviesstage1.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public class MovieListPresenter<V extends MovieListMvpView> extends BasePresenter<V>
        implements MovieListMvpPresenter<V> {

    private static final String TAG = MovieListPresenter.class.getSimpleName();

    private int nextPage = 1;
    private BehaviorSubject<Boolean> isLoading = BehaviorSubject.create();
    private boolean sortByPopularity = true;

    @Inject
    public MovieListPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void init() {
        getCompositeDisposable().add(isLoading.subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                getMvpView().showLoader(aBoolean ? View.VISIBLE : View.GONE);
            }
        }));

        isLoading.onNext(false);

        fetchMovieList();
    }

    @Override
    public void onMovieListScrolled(int dy, int visibleItemCount, int totalItemCount, int pastVisibleItems, int lastVisibleItem) {
        if (dy > 0) {
            if ((lastVisibleItem + 6) >= totalItemCount) {
                fetchMovieList();
            }
        }
    }

    @Override
    public void sortByPopularitySelected() {
        if (sortByPopularity)
            return;

        nextPage = 1;
        sortByPopularity = true;
        fetchMovieList();
    }

    @Override
    public void sortByRatingSelected() {
        if (!sortByPopularity)
            return;
        nextPage = 1;
        sortByPopularity = false;
        fetchMovieList();
    }

    @Override
    public void fetchMovieList() {
        if (isLoading.getValue())
            return;

        if (getMvpView().isNetworkConnected()) {
            Observable<PopularMovieResponseModel> observable;
            if (sortByPopularity) {
                observable = getDataManager().getPopularMovies(nextPage);
            } else {
                observable = getDataManager().getTopRatedMovies(nextPage);
            }
            getCompositeDisposable().add(
                    observable
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .doOnSubscribe(new Consumer<Disposable>() {
                                @Override
                                public void accept(Disposable disposable) throws Exception {
                                    isLoading.onNext(true);
                                }
                            })
                            .doOnComplete(new Action() {
                                @Override
                                public void run() throws Exception {
                                    isLoading.onNext(false);
                                }
                            })
                            .doOnError(new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    isLoading.onNext(false);
                                }
                            })
                            .subscribe(new Consumer<PopularMovieResponseModel>() {
                                @Override
                                public void accept(PopularMovieResponseModel popularMovieResponseModel) throws Exception {
                                    if (popularMovieResponseModel.getPage() < nextPage) {
                                        return;
                                    }
                                    if (nextPage == 1) {
                                        getMvpView().populateMovieGrid(popularMovieResponseModel);
                                    } else {
                                        getMvpView().appendMovieGrid(popularMovieResponseModel);
                                    }
                                    if (popularMovieResponseModel.getTotalPages() > nextPage) {
                                        nextPage = popularMovieResponseModel.getPage() + 1;
                                    }
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    throwable.printStackTrace();
                                    getMvpView().onError(throwable.getMessage());
                                    getMvpView().showApiErrorRetryDialog();
                                }
                            }));
        } else {
            getMvpView().showInternetRetryDialog();
        }
    }
}
