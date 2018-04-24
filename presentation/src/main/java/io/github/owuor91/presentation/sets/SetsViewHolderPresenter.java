package io.github.owuor91.presentation.sets;

import android.content.Context;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.domain.models.Set;
import io.github.owuor91.presentation.BasePresenter;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class SetsViewHolderPresenter implements BasePresenter {
  private View view;
  private Context context;
  private int position;
  private SetsAdapterPresenter setsAdapterPresenter;

  @Inject public SetsViewHolderPresenter(@Named(DIConstants.APP) Context context) {
    this.context = context;
  }

  public void setView(View view) {
    this.view = view;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public void setSetsAdapterPresenter(SetsAdapterPresenter setsAdapterPresenter) {
    this.setsAdapterPresenter = setsAdapterPresenter;
  }

  public void bind() {
    Set set = setsAdapterPresenter.getSetAt(position);
    view.setCode(set.getCode());
    view.setName(set.getName());
    view.setType(set.getType());
    view.setBorder(set.getBorder());
    view.setReleaseDate(set.getReleaseDate());
    view.setInfoCode(set.getMagicCardsInfoCode());
  }

  @Override public void dispose() {

  }

  public interface View extends BasePresenter.View {
    void setCode(String code);

    void setName(String name);

    void setType(String type);

    void setBorder(String border);

    void setReleaseDate(Date releaseDate);

    void setInfoCode(String infoCode);
  }
}
