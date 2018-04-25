package io.github.owuor91.mtg.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.BindView;
import io.github.owuor91.mtg.R;
import io.github.owuor91.mtg.ui.fragments.SetsFragment;

public class MainActivity extends BaseActivity {
  @BindView(R.id.mainActivityTvTitle) TextView tvTitle;
  @BindView(R.id.mainActivityToolbar) Toolbar toolbar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    injector().inject(this);

    getSupportFragmentManager().beginTransaction()
        .replace(R.id.mainActivityFrameLayout, new SetsFragment())
        .addToBackStack(null)
        .commit();
  }

  @Override protected void onStart() {
    super.onStart();
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
  }

  public void setToolbarTitle(String toolbarTitleText) {
    tvTitle.setText(toolbarTitleText);
  }

  public void showUpNavigation() {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  public void hideUpNavigation() {
    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
