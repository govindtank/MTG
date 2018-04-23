package io.github.owuor91.mtg.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import io.github.owuor91.domain.models.Set;
import io.github.owuor91.mtg.R;
import io.github.owuor91.presentation.sets.SetsPresenter;
import java.util.List;
import javax.inject.Inject;

public class SetsFragment extends BaseFragment implements SetsPresenter.View {
  @Inject SetsPresenter setsPresenter;

  public SetsFragment() {
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_sets;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().inject(this);
  }

  @Override public void onStart() {
    super.onStart();
    setsPresenter.setView(this);
  }

  @Override public void onResume() {
    super.onResume();
    setsPresenter.fetchSets();
  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void displaySets(List<Set> sets) {
    int count = sets.size();
    Log.d(this.getClass().getName(), String.valueOf(count));
  }
}
