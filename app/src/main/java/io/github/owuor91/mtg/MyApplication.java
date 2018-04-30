package io.github.owuor91.mtg;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import io.github.owuor91.mtg.di.activity.ActivityComponent;
import io.github.owuor91.mtg.di.activity.ActivityModule;
import io.github.owuor91.mtg.di.app.AndroidModule;
import io.github.owuor91.mtg.di.app.ApplicationComponent;
import io.github.owuor91.mtg.di.app.ApplicationModule;
import io.github.owuor91.mtg.di.app.DaggerApplicationComponent;
import io.github.owuor91.mtg.ui.activities.BaseActivity;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class MyApplication extends Application {
  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .androidModule(new AndroidModule(this))
        .build();
    applicationComponent.inject(this);

    Fabric.with(this, new Crashlytics());
  }

  public ActivityComponent getActivityInjector(BaseActivity baseActivity) {
    return applicationComponent.activityComponentBuilder().activityModule(new ActivityModule(baseActivity)).build();
  }
}
