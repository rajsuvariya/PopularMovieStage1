package com.rajsuvariya.popularmoviesstage1.data.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PreferencesHelper_Factory implements Factory<PreferencesHelper> {
  private final Provider<Context> contextProvider;

  public PreferencesHelper_Factory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public PreferencesHelper get() {
    return new PreferencesHelper(contextProvider.get());
  }

  public static Factory<PreferencesHelper> create(Provider<Context> contextProvider) {
    return new PreferencesHelper_Factory(contextProvider);
  }
}
