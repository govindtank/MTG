package io.github.owuor91.mtg.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.mtg.R;
import io.github.owuor91.mtg.ui.adapters.CardsAdapter;
import io.github.owuor91.presentation.cards.CardsListPresenter;
import java.util.List;
import javax.inject.Inject;

public class CardsListFragment extends BaseFragment implements CardsListPresenter.View {

  public static final String KEY_CODE = "KEY_CODE";
  public static String mSetCode;
  @BindView(R.id.cardsListFragmentRecyclerView) RecyclerView cardsRecyclerView;
  @BindView(R.id.cardsListFragmentProgressBar) ProgressBar progressBar;
  @Inject CardsListPresenter cardsListPresenter;
  private CardsAdapter cardsAdapter;

  public CardsListFragment() {

  }

  public static CardsListFragment newInstance(String setCode) {
    CardsListFragment cardsListFragment = new CardsListFragment();
    Bundle args = new Bundle();
    args.putString(KEY_CODE, setCode);
    cardsListFragment.setArguments(args);
    mSetCode = setCode;
    return cardsListFragment;
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_cards_list;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().inject(this);
  }

  @Override public void onStart() {
    super.onStart();

    cardsListPresenter.setView(this);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    cardsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
  }

  @Override public void onResume() {
    super.onResume();
    cardsListPresenter.getSetCards(mSetCode);
  }

  @Override public void displaySetCards(List<Card> cardList) {
    if (cardsAdapter == null) {
      cardsAdapter = new CardsAdapter(activityInjector(), getContext());
    }

    if (cardsRecyclerView.getAdapter() == null) {
      cardsRecyclerView.setAdapter(cardsAdapter);
    }

    cardsAdapter.cardsAdapterPresenter.setCardsListPresenter(cardsListPresenter);
    cardsAdapter.cardsAdapterPresenter.onDataChange(cardList);
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void openCard(String cardId) {
    getFragmentManager().beginTransaction()
        .replace(R.id.mainActivityFrameLayout, CardFragment.newInstance(cardId))
        .addToBackStack(null)
        .commit();
  }
}
