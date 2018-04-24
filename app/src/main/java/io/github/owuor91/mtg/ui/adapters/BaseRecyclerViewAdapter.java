package io.github.owuor91.mtg.ui.adapters;

import android.support.v7.widget.RecyclerView;
import io.github.owuor91.mtg.di.activity.ActivityComponent;
import io.github.owuor91.mtg.di.adapter.AdapterComponent;

/**
 * Created by johnowuor on 24/04/2018.
 */

public abstract class BaseRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
  private final ActivityComponent activityComponent;

  public BaseRecyclerViewAdapter(ActivityComponent activityComponent) {
    this.activityComponent = activityComponent;
  }

  protected AdapterComponent injector() {
    return activityComponent.adapterBuilder().build();
  }
}
