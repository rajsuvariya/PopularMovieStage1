package com.rajsuvariya.popularmoviesstage1.utils;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "mindorks_mvp.db";
    public static final String PREF_NAME = "mindorks_pref";

    public static final long NULL_INDEX = -1L;

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String YOUTUBE_THUMBNAIL_BASE_URL= "https://img.youtube.com/vi/";
    public static final String TMDB_IMAGE_BASE_URL_W500 = "https://image.tmdb.org/t/p/w500";
    public static final String TMDB_IMAGE_BASE_URL_W342 = "https://image.tmdb.org/t/p/w342";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
