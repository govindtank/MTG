package io.github.owuor91.mtg.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.owuor91.mtg.di.activity.ActivityComponent;
import io.github.owuor91.presentation.sets.SetsAdapterPresenter;
import javax.inject.Inject;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class SetsAdapter extends BaseRecyclerViewAdapter<SetsViewHolder> implements SetsAdapterPresenter.View {
  @Inject public SetsAdapterPresenter setsAdapterPresenter;
  @Inject LayoutInflater layoutInflater;
  private Context context;

  public SetsAdapter(ActivityComponent activityComponent, Context context) {
    super(activityComponent);
    injector().inject(this);
    setsAdapterPresenter.setView(this);
    this.context = context;
  }

  @Override public SetsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = layoutInflater.inflate(SetsViewHolder.LAYOUT_ID, parent, false);
    return new SetsViewHolder(view, injector());
  }

  @Override public void onBindViewHolder(SetsViewHolder holder, int position) {
    holder.setsViewHolderPresenter.setPosition(position);
    holder.setsViewHolderPresenter.setSetsAdapterPresenter(setsAdapterPresenter);
    holder.setsViewHolderPresenter.bind();
  }

  @Override public int getItemCount() {
    return setsAdapterPresenter.getCount();
  }

  @Override public void handleError(Throwable throwable) {

  }

  @Override public void notifyAdapter() {
    notifyDataSetChanged();
  }
}
