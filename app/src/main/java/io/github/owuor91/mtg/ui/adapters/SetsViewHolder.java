package io.github.owuor91.mtg.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import io.github.owuor91.domain.Constants;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.mtg.R;
import io.github.owuor91.mtg.di.adapter.AdapterComponent;
import io.github.owuor91.presentation.sets.SetsViewHolderPresenter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class SetsViewHolder extends BaseViewHolder implements SetsViewHolderPresenter.View {
  public static final int LAYOUT_ID = R.layout.set_list_item;
  @Inject public SetsViewHolderPresenter setsViewHolderPresenter;
  @Inject @Named(DIConstants.APP) Context context;

  @BindView(R.id.setListItemTvCode) TextView tvCode;
  @BindView(R.id.setListItemTvName) TextView tvName;
  @BindView(R.id.setListItemTvType) TextView tvType;
  @BindView(R.id.setListItemTvBorder) TextView tvBorder;
  @BindView(R.id.setListItemTvReleaseDate) TextView tvReleaseDate;
  @BindView(R.id.setListItemTvInfoCode) TextView tvInfoCode;
  @BindView(R.id.setListItemCardView) CardView cardView;

  public SetsViewHolder(View itemView, AdapterComponent adapterComponent) {
    super(itemView);
    adapterComponent.inject(this);
    setsViewHolderPresenter.setView(this);
  }

  @Override public void handleError(Throwable throwable) {

  }

  @Override public void setCode(String code) {
    tvCode.setText(String.format("%s %s", context.getString(R.string.code), code));
  }

  @Override public void setName(String name) {
    tvName.setText(String.format("%s %s", context.getString(R.string.name), name));
  }

  @Override public void setType(String type) {
    tvType.setText(String.format("%s %s", context.getString(R.string.type), type));
  }

  @Override public void setBorder(String border) {
    tvBorder.setText(String.format("%s %s", context.getString(R.string.border), border));
  }

  @Override public void setReleaseDate(Date releaseDate) {
    DateFormat dateFormat = new SimpleDateFormat(Constants.DD_MMMM_YYYY);
    String rdString = dateFormat.format(releaseDate);
    tvReleaseDate.setText(String.format("%s %s", context.getString(R.string.releaseDate), rdString));
  }

  @Override public void setInfoCode(String infoCode) {
    tvInfoCode.setText(String.format("%s %s", context.getString(R.string.infoCode), infoCode));
  }

  @OnClick(R.id.setListItemCardView) public void onClickSetCard() {
    setsViewHolderPresenter.onSetClick();
  }

  @OnClick(R.id.setListItemTvBooster) public void onClickBooster() {
    setsViewHolderPresenter.onBoosterClick();
  }

}
