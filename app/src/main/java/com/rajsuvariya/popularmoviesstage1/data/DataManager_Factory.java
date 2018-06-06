package com.rajsuvariya.popularmoviesstage1.data;

import com.rajsuvariya.popularmoviesstage1.data.local.PreferencesHelper;
import com.rajsuvariya.popularmoviesstage1.data.remote.AppApiHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataManager_Factory implements Factory<DataManager> {
  private final Provider<PreferencesHelper> preferencesHelperProvider;

  private final Provider<AppApiHelper> apiHelperProvider;

  public DataManager_Factory(
      Provider<PreferencesHelper> preferencesHelperProvider,
      Provider<AppApiHelper> apiHelperProvider) {
    assert preferencesHelperProvider != null;
    this.preferencesHelperProvider = preferencesHelperProvider;
    assert apiHelperProvider != null;
    this.apiHelperProvider = apiHelperProvider;
  }

  @Override
  public DataManager get() {
    return new DataManager(preferencesHelperProvider.get(), apiHelperProvider.get());
  }

  public static Factory<DataManager> create(
      Provider<PreferencesHelper> preferencesHelperProvider,
      Provider<AppApiHelper> apiHelperProvider) {
    return new DataManager_Factory(preferencesHelperProvider, apiHelperProvider);
  }
}
