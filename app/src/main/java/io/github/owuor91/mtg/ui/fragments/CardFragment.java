package io.github.owuor91.mtg.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.presentation.cards.CardPresenter;
import javax.inject.Inject;

public class CardFragment extends BaseFragment implements CardPresenter.View {

  public static final String KEY_CARD_ID = "KEY_CARD_ID";
  public static String mCardId;
  @Inject CardPresenter cardPresenter;

  public CardFragment() {
  }

  public static CardFragment newInstance(String cardId) {
    CardFragment cardFragment = new CardFragment();
    Bundle args = new Bundle();
    args.putString(KEY_CARD_ID, cardId);
    cardFragment.setArguments(args);
    mCardId = cardId;
    return cardFragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().inject(this);
  }

  @Override public void onStart() {
    super.onStart();
    cardPresenter.setView(this);
  }

  @Override public void onResume() {
    super.onResume();
    cardPresenter.getCardDetails(mCardId);
  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void displayCardDetails(Card card) {
    Log.d("wow", card.getName());
  }
}
