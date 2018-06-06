
package com.rajsuvariya.popularmoviesstage1.injection.component;

import android.app.Application;
import android.content.Context;

import com.rajsuvariya.popularmoviesstage1.IfaApp;
import com.rajsuvariya.popularmoviesstage1.data.DataManager;
import com.rajsuvariya.popularmoviesstage1.injection.ApplicationContext;
import com.rajsuvariya.popularmoviesstage1.injection.module.ApplicationModule;

import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(IfaApp app);


    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}