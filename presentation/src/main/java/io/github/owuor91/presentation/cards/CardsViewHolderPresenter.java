package io.github.owuor91.presentation.cards;

import android.content.Context;
import io.github.owuor91.domain.Constants;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.presentation.BasePresenter;
import java.util.ArrayList;
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

    setColors(card.getColors());

    view.setName(card.getName());
  }

  void setColors(ArrayList<String> colorsArray) {
    if (colorsArray == null) return;
    String colors = Constants.EMPTY_STRING;
    if (colorsArray.size() > 1) {
      for (String color : colorsArray) {
        colors += color;
        colors += Constants.COMMA_SPACE;
      }
    } else {
      colors = colorsArray.get(0);
    }

    view.setColors(colors);
  }

  @Override public void dispose() {

  }

  public interface View extends BasePresenter.View {
    void setImage(String imageUrl);

    void setColors(String colors);

    void setName(String name);
  }
}
