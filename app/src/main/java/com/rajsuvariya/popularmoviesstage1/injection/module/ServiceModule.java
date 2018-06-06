package com.rajsuvariya.popularmoviesstage1.injection.module;

import android.app.Service;
import dagger.Module;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }
}
