package io.github.owuor91.mtg.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import com.squareup.picasso.Picasso;
import io.github.owuor91.mtg.R;
import io.github.owuor91.mtg.ui.activities.MainActivity;
import io.github.owuor91.presentation.cards.CardPresenter;
import javax.inject.Inject;

public class CardFragment extends BaseFragment implements CardPresenter.View {

  public static final String KEY_CARD_ID = "KEY_CARD_ID";
  public static String mCardId;
  @Inject CardPresenter cardPresenter;
  @BindView(R.id.cardFragmentImgCard) ImageView imageCard;
  @BindView(R.id.cardFragmentTvArtist) TextView tvArtist;
  @BindView(R.id.cardFragmentTvColors) TextView tvColors;
  @BindView(R.id.cardFragmentTvSetName) TextView tvSetName;
  @BindView(R.id.cardFragmentTvText) TextView tvText;
  @BindView(R.id.cardFragmentProgressBar) ProgressBar progressBar;

  public CardFragment() {
  }

  public static CardFragment newInstance(String cardId) {
    CardFragment cardFragment = new CardFragment();
    Bundle args = new Bundle();
    args.putString(KEY_CARD_ID, cardId);
    cardFragment.setArguments(args);
    mCardId = cardId;
    return cardFragment;
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_card;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().inject(this);
  }

  @Override public void onStart() {
    super.onStart();
    cardPresenter.setView(this);
  }

  @Override public void onResume() {
    super.onResume();
    ((MainActivity) getActivity()).showUpNavigation();
    cardPresenter.getCardDetails(mCardId);
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void setTitle(String title) {
    ((MainActivity) getActivity()).setToolbarTitle(title);
  }

  @Override public void setCardImage(String imageUrl) {
    Picasso.with(getContext())
        .load(imageUrl)
        .placeholder(R.drawable.ic_insert_photo_pink_100_48dp)
        .error(R.drawable.ic_insert_photo_pink_100_48dp)
        .fit()
        .centerInside()
        .into(imageCard);
  }

  @Override public void setArtistName(String artistName) {
    tvArtist.setText(String.format("%s %s", getString(R.string.artist), artistName));
  }

  @Override public void setColors(String colors) {
    tvColors.setText(String.format("%s %s", getString(R.string.colors), colors));
  }

  @Override public void setSetName(String setName) {
    tvSetName.setText(String.format("%s %s", getString(R.string.set), setName));
  }

  @Override public void setText(String text) {
    tvText.setText(String.format("%s %s", getString(R.string.text), text));
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);

  }
}
