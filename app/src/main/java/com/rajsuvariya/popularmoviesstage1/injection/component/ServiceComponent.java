
package com.rajsuvariya.popularmoviesstage1.injection.component;

import com.rajsuvariya.popularmoviesstage1.injection.PerService;
import com.rajsuvariya.popularmoviesstage1.injection.module.ServiceModule;

import dagger.Component;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {


}
