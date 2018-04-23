package io.github.owuor91.mtg.di.app;

import dagger.Component;
import io.github.owuor91.mtg.MyApplication;
import io.github.owuor91.mtg.di.activity.ActivityComponent;
import javax.inject.Singleton;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {
  ActivityComponent.Builder activityComponentBuilder();

  void inject(MyApplication myApplication);
}
