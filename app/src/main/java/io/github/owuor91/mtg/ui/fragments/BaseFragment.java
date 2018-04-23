package io.github.owuor91.mtg.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import io.github.owuor91.data.utils.RxUtils;
import io.github.owuor91.mtg.di.activity.ActivityComponent;
import io.github.owuor91.mtg.di.fragment.FragmentComponent;
import io.github.owuor91.mtg.di.fragment.FragmentModule;
import io.github.owuor91.mtg.ui.activities.BaseActivity;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class BaseFragment extends Fragment {
  private static final int NO_LAYOUT = -1;
  private CompositeDisposable compositeDisposable;

  public int getLayoutId() {
    return NO_LAYOUT;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().baseInject(this);
  }

  @Override public void onStart() {
    super.onStart();
    compositeDisposable = RxUtils.initDisposables(compositeDisposable);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    if (getLayoutId() != NO_LAYOUT) {
      View view = inflater.inflate(getLayoutId(), container, false);
      ButterKnife.bind(this, view);
      return view;
    } else {
      return super.onCreateView(inflater, container, savedInstanceState);
    }
  }

  protected FragmentComponent injector() {
    return activityInjector().fragmentBuilder().fragmentModule(new FragmentModule(this)).build();
  }

  protected ActivityComponent activityInjector() {
    return ((BaseActivity) getActivity()).injector();
  }

  public void handleError(Throwable throwable) {
    Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
  }

  protected void dispose() {
    RxUtils.dispose(compositeDisposable);
  }
}
