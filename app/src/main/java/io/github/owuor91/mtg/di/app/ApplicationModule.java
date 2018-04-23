package io.github.owuor91.mtg.di.app;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.mtg.MyApplication;
import io.github.owuor91.mtg.di.activity.ActivityComponent;
import javax.inject.Named;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Module(includes = AndroidModule.class, subcomponents = { ActivityComponent.class }) public class ApplicationModule {
  private final MyApplication myApplication;

  public ApplicationModule(MyApplication myApplication) {
    this.myApplication = myApplication;
  }

  @Provides @Named(DIConstants.APP) public Context provideAppContext() {
    return myApplication;
  }
}
