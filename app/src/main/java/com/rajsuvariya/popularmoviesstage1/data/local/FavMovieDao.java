package com.rajsuvariya.popularmoviesstage1.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;

import java.util.List;

/**
 * Created by @raj on 11/06/18.
 */

@Dao
public interface FavMovieDao {

    @Query("SELECT * FROM fav_movies")
    List<MovieDetailsOutputModel> getAllFavMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieDetailsOutputModel movie);

    @Delete
    void delete(MovieDetailsOutputModel user);

    @Query("SELECT * FROM fav_movies WHERE id = :id")
    MovieDetailsOutputModel getMovieDetails(int id);
}
