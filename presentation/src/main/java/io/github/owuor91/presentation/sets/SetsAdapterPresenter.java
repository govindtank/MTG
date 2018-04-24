package io.github.owuor91.presentation.sets;

import io.github.owuor91.domain.models.Set;
import io.github.owuor91.presentation.BasePresenter;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class SetsAdapterPresenter implements BasePresenter {
  private List<Set> sets;
  private View view;
  private SetsPresenter setsPresenter;

  @Inject public SetsAdapterPresenter() {
  }

  public void setSetsPresenter(SetsPresenter setsPresenter) {
    this.setsPresenter = setsPresenter;
  }

  public void setView(View view) {
    this.view = view;
  }

  public int getCount() {
    return sets.size();
  }

  public Set getSetAt(int position) {
    return sets.get(position);
  }

  public void onDataChange(List<Set> sets) {
    this.sets = sets;
    view.notifyAdapter();
  }

  @Override public void dispose() {

  }

  public void onSetClick(int position) {
    setsPresenter.onSetClick(sets.get(position).getCode());
  }

  public interface View extends BasePresenter.View {
    void notifyAdapter();
  }
}
