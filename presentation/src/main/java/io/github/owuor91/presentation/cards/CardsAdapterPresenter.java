package io.github.owuor91.presentation.cards;

import io.github.owuor91.domain.models.Card;
import io.github.owuor91.presentation.BasePresenter;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class CardsAdapterPresenter implements BasePresenter {
  private List<Card> cardList;
  private View view;
  private CardsListPresenter cardsListPresenter;

  @Inject public CardsAdapterPresenter() {
  }

  public void setView(View view) {
    this.view = view;
  }

  public void setCardsListPresenter(CardsListPresenter cardsListPresenter) {
    this.cardsListPresenter = cardsListPresenter;
  }

  public int getCount() {
    return cardList.size();
  }

  public Card getCardAt(int position) {
    return cardList.get(position);
  }

  public void onDataChange(List<Card> cardList) {
    this.cardList = cardList;
    view.notifyAdapter();
  }

  @Override public void dispose() {

  }

  public interface View extends BasePresenter.View {
    void notifyAdapter();
  }
}
