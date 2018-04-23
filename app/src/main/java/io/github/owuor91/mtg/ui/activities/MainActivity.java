package io.github.owuor91.mtg.ui.activities;

import android.os.Bundle;
import io.github.owuor91.mtg.R;
import io.github.owuor91.mtg.ui.fragments.SetsFragment;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    injector().inject(this);
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.mainActivityFrameLayout, new SetsFragment())
        .addToBackStack(null)
        .commit();
  }
}
