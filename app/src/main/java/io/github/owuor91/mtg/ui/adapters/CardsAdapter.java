package io.github.owuor91.mtg.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.owuor91.mtg.di.activity.ActivityComponent;
import io.github.owuor91.presentation.cards.CardsAdapterPresenter;
import javax.inject.Inject;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class CardsAdapter extends BaseRecyclerViewAdapter<CardsViewHolder> implements CardsAdapterPresenter.View {
  @Inject public CardsAdapterPresenter cardsAdapterPresenter;
  @Inject LayoutInflater layoutInflater;
  private Context context;

  public CardsAdapter(ActivityComponent activityComponent, Context context) {
    super(activityComponent);
    this.context = context;
    injector().inject(this);
    cardsAdapterPresenter.setView(this);
  }

  @Override public CardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = layoutInflater.inflate(CardsViewHolder.LAYOUT_ID, parent, false);
    return new CardsViewHolder(view, injector());
  }

  @Override public void onBindViewHolder(CardsViewHolder holder, int position) {
    holder.cardsViewHolderPresenter.setPosition(position);
    holder.cardsViewHolderPresenter.setCardsAdapterPresenter(cardsAdapterPresenter);
    holder.cardsViewHolderPresenter.bind();
  }

  @Override public int getItemCount() {
    return cardsAdapterPresenter.getCount();
  }

  @Override public void handleError(Throwable throwable) {

  }

  @Override public void notifyAdapter() {
    notifyDataSetChanged();
  }
}
