package io.github.owuor91.mtg.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.squareup.picasso.Picasso;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.mtg.R;
import io.github.owuor91.mtg.di.adapter.AdapterComponent;
import io.github.owuor91.presentation.cards.CardsViewHolderPresenter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class CardsViewHolder extends BaseViewHolder implements CardsViewHolderPresenter.View {

  public static final int LAYOUT_ID = R.layout.card_list_item;
  @Inject public CardsViewHolderPresenter cardsViewHolderPresenter;
  @Inject @Named(DIConstants.APP) Context context;

  @BindView(R.id.cardListItemCardView) CardView cardView;
  @BindView(R.id.cardListItemImageView) ImageView imageView;
  @BindView(R.id.cardListItemTvName) TextView tvName;
  @BindView(R.id.cardListItemTvColors) TextView tvColors;

  public CardsViewHolder(View itemView, AdapterComponent adapterComponent) {
    super(itemView);
    adapterComponent.inject(this);
    cardsViewHolderPresenter.setView(this);
  }

  @Override public void handleError(Throwable throwable) {

  }

  @Override public void setImage(String imageUrl) {
    Picasso.with(context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_insert_photo_pink_100_48dp)
        .error(R.drawable.ic_insert_photo_pink_100_48dp)
        .fit()
        .centerInside()
        .into(imageView);
  }

  @Override public void setColors(String colors) {
    tvColors.setText(String.format("%s %s", context.getString(R.string.colors), colors));
  }

  @Override public void setName(String name) {
    tvName.setText(String.format("%s %s", context.getString(R.string.name), name));
  }
}
