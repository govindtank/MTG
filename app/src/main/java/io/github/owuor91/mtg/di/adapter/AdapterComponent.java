package io.github.owuor91.mtg.di.adapter;

import dagger.Subcomponent;
import io.github.owuor91.mtg.ui.adapters.SetsAdapter;
import io.github.owuor91.mtg.ui.adapters.SetsViewHolder;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Subcomponent(modules = { AdapterModule.class }) public interface AdapterComponent {

  void inject(SetsViewHolder setsViewHolder);

  void inject(SetsAdapter setsAdapter);

  @Subcomponent.Builder interface Builder {
    Builder adapterModule(AdapterModule adapterModule);

    AdapterComponent build();
  }
}
