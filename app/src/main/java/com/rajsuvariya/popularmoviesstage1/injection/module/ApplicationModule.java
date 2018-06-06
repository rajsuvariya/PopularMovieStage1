
package com.rajsuvariya.popularmoviesstage1.injection.module;

import android.app.Application;
import android.content.Context;

import com.rajsuvariya.popularmoviesstage1.BuildConfig;
import com.rajsuvariya.popularmoviesstage1.data.local.PreferencesHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.ApiHeader;
import com.rajsuvariya.popularmoviesstage1.data.remote.ApiHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.AppApiHelper;
import com.rajsuvariya.popularmoviesstage1.injection.ApiInfo;
import com.rajsuvariya.popularmoviesstage1.injection.ApplicationContext;
import com.rajsuvariya.popularmoviesstage1.injection.DatabaseInfo;
import com.rajsuvariya.popularmoviesstage1.injection.PreferenceInfo;
import com.rajsuvariya.popularmoviesstage1.utils.AppConstants;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.api_key_v3;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        //return new ApiHeader.ProtectedApiHeader(
        //        apiKey,
        //        preferencesHelper.getCurrentUserId(),
        //        preferencesHelper.getAccessToken());

        return new ApiHeader.ProtectedApiHeader(
            apiKey,
            "",
            "");
    }


}
