package io.github.owuor91.mtg.di.fragment;

import dagger.Module;
import io.github.owuor91.mtg.ui.fragments.BaseFragment;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Module public class FragmentModule {

  private BaseFragment baseFragment;

  public FragmentModule(BaseFragment baseFragment) {
    this.baseFragment = baseFragment;
  }
}
