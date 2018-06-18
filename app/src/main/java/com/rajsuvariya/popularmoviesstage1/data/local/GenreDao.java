package com.rajsuvariya.popularmoviesstage1.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rajsuvariya.popularmoviesstage1.data.remote.model.Genre;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;

import java.util.List;

/**
 * Created by @raj on 12/06/18.
 */

@Dao
public interface GenreDao {

    @Query("SELECT * FROM genres WHERE movieId = :movieId")
    List<Genre> getGenresOfMovie(Integer movieId);

    @Insert
    void saveGenresOfMovie(List<Genre> genres);
}
