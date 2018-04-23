package io.github.owuor91.mtg.di.activity;

import dagger.Subcomponent;
import io.github.owuor91.mtg.di.fragment.FragmentComponent;
import io.github.owuor91.mtg.ui.activities.BaseActivity;
import io.github.owuor91.mtg.ui.activities.MainActivity;

/**
 * Created by johnowuor on 23/04/2018.
 */

@ActivityScope @Subcomponent(modules = { ActivityModule.class }) public interface ActivityComponent {

  FragmentComponent.Builder fragmentBuilder();

  void baseInject(BaseActivity baseActivity);

  void inject(MainActivity mainActivity);

  @Subcomponent.Builder interface Builder {
    Builder activityModule(ActivityModule activityModule);

    ActivityComponent build();
  }
}
