package io.github.owuor91.mtg.di.fragment;

import dagger.Subcomponent;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Subcomponent(modules = FragmentModule.class) public interface FragmentComponent {

  @Subcomponent.Builder interface Builder {
    Builder fragmentModule(FragmentModule fragmentModule);

    FragmentComponent build();
  }
}
