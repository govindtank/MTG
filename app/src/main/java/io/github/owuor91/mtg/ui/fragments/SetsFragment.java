package io.github.owuor91.mtg.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import io.github.owuor91.domain.models.Set;
import io.github.owuor91.mtg.R;
import io.github.owuor91.mtg.ui.activities.MainActivity;
import io.github.owuor91.mtg.ui.adapters.SetsAdapter;
import io.github.owuor91.presentation.sets.SetsPresenter;
import java.util.List;
import javax.inject.Inject;

public class SetsFragment extends BaseFragment implements SetsPresenter.View {
  @Inject SetsPresenter setsPresenter;
  @BindView(R.id.setsFragmentRecyclerView) RecyclerView setsRecyclerView;
  @BindView(R.id.setsFragmentProgressBar) ProgressBar progressBar;
  private SetsAdapter setsAdapter;

  public SetsFragment() {
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_sets;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().inject(this);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
  }

  @Override public void onStart() {
    super.onStart();
    setsPresenter.setView(this);
  }

  @Override public void onResume() {
    super.onResume();
    ((MainActivity) getActivity()).setToolbarTitle(getString(R.string.sets));
    ((MainActivity) getActivity()).hideUpNavigation();
    setsPresenter.fetchSets();
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void displaySets(List<Set> setsList) {
    if (setsAdapter == null) {
      setsAdapter = new SetsAdapter(activityInjector(), getContext());
    }

    if (setsRecyclerView.getAdapter() == null) {
      setsRecyclerView.setAdapter(setsAdapter);
    }

    setsAdapter.setsAdapterPresenter.setSetsPresenter(setsPresenter);
    setsAdapter.setsAdapterPresenter.onDataChange(setsList);
  }

  @Override public void openSet(String setCode) {
    getFragmentManager().beginTransaction()
        .replace(R.id.mainActivityFrameLayout, CardsListFragment.newInstance(setCode))
        .addToBackStack(null)
        .commit();
  }
}
