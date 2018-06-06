
package com.rajsuvariya.popularmoviesstage1.injection.component;


import com.rajsuvariya.popularmoviesstage1.injection.PerActivity;
import com.rajsuvariya.popularmoviesstage1.injection.module.ActivityModule;
import com.rajsuvariya.popularmoviesstage1.ui.movieDetails.MovieDetailsActivity;
import com.rajsuvariya.popularmoviesstage1.ui.movieListing.MovieListActivity;
import com.rajsuvariya.popularmoviesstage1.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);
    void inject(MovieListActivity loginActivity);

    void inject(MovieDetailsActivity movieDetailsActivity);
}
