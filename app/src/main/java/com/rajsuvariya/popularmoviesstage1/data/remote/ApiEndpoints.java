
package com.rajsuvariya.popularmoviesstage1.data.remote;


import com.rajsuvariya.popularmoviesstage1.BuildConfig;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.PopularMovieResponseModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public interface ApiEndpoints {

    @GET("movie/popular")
    Observable<PopularMovieResponseModel> getPopularMovies(@Query("api_key") String apiKey, @Query("page") int pageNumber);

    @GET("movie/top_rated")
    Observable<PopularMovieResponseModel> getTopRatedMovies(@Query("api_key") String api_key_v3, @Query("page") int pageNumber);
}
