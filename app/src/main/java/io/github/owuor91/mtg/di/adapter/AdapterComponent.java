package io.github.owuor91.mtg.di.adapter;

import dagger.Subcomponent;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Subcomponent(modules = { AdapterModule.class }) public interface AdapterComponent {

  @Subcomponent.Builder interface Builder {
    Builder adapterModule(AdapterModule adapterModule);

    AdapterComponent build();
  }
}
