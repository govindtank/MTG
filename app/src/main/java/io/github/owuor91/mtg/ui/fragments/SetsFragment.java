package io.github.owuor91.mtg.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import io.github.owuor91.mtg.R;

public class SetsFragment extends BaseFragment {

  public SetsFragment() {
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_sets;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().inject(this);
  }
}
