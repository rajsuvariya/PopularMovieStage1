package com.rajsuvariya.popularmoviesstage1.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.rajsuvariya.popularmoviesstage1.data.remote.model.Genre;
import com.rajsuvariya.popularmoviesstage1.data.remote.model.MovieDetailsOutputModel;

/**
 * Created by @raj on 11/06/18.
 */
@Database(entities = {MovieDetailsOutputModel.class, Genre.class}, version = 1, exportSchema = false) //Entities listed here
public abstract class AppDataBase extends RoomDatabase {
    public abstract FavMovieDao favMovieDao();
    public abstract GenreDao genreDao();

    private static AppDataBase sInstance;
    private static final Object LOCK = new Object();
    private static final String DB_NAME = "movie_buzz";

    public static AppDataBase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context,
                            AppDataBase.class, DB_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return sInstance;
    }
}
