package com.rajsuvariya.popularmoviesstage1;

import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.rajsuvariya.popularmoviesstage1.data.DataManager;
import com.rajsuvariya.popularmoviesstage1.injection.component.ApplicationComponent;
import com.rajsuvariya.popularmoviesstage1.injection.component.DaggerApplicationComponent;
import com.rajsuvariya.popularmoviesstage1.injection.module.ApplicationModule;

import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public class IfaApp extends Application {
  @Inject
  DataManager mDataManager;


  private ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this)).build();

    mApplicationComponent.inject(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    AndroidNetworking.initialize(getApplicationContext());
    if (BuildConfig.DEBUG) {
      AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
    }
  }

  public ApplicationComponent getComponent() {
    return mApplicationComponent;
  }


  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}
