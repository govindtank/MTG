package io.github.owuor91.presentation.cards;

import android.content.Context;
import io.github.owuor91.data.utils.ArrayListUtils;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.presentation.BasePresenter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class CardsViewHolderPresenter implements BasePresenter {
  private View view;
  private Context context;
  private int position;
  private CardsAdapterPresenter cardsAdapterPresenter;

  @Inject public CardsViewHolderPresenter(@Named(DIConstants.APP) Context context) {
    this.context = context;
  }

  public void setView(View view) {
    this.view = view;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public void setCardsAdapterPresenter(CardsAdapterPresenter cardsAdapterPresenter) {
    this.cardsAdapterPresenter = cardsAdapterPresenter;
  }

  public void bind() {
    Card card = cardsAdapterPresenter.getCardAt(position);

    view.setImage(card.getImageUrl());

    view.setColors(ArrayListUtils.convertArrayListToString(card.getColors()));

    view.setName(card.getName());
  }

  @Override public void dispose() {

  }

  public void onClickCard() {
    cardsAdapterPresenter.onClickCard(position);
  }

  public interface View extends BasePresenter.View {
    void setImage(String imageUrl);

    void setColors(String colors);

    void setName(String name);
  }
}
