package io.github.owuor91.mtg.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import io.github.owuor91.mtg.MyApplication;
import io.github.owuor91.mtg.di.activity.ActivityComponent;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class BaseActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().baseInject(this);
  }

  public ActivityComponent injector() {
    return ((MyApplication) getApplicationContext()).getActivityInjector(this);
  }

  @Override protected void onStart() {
    super.onStart();
    ButterKnife.bind(this);
  }
}
