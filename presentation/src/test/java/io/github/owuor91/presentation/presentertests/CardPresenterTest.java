package io.github.owuor91.presentation.presentertests;

import io.github.owuor91.data.utils.ArrayListUtils;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.repository.CardRepository;
import io.github.owuor91.presentation.TrampolineSchedulerRule;
import io.github.owuor91.presentation.cards.CardPresenter;
import io.reactivex.Single;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by johnowuor on 30/04/2018.
 */

@RunWith(MockitoJUnitRunner.class) public class CardPresenterTest {
  @Rule public final TrampolineSchedulerRule trampolineSchedulerRule = new TrampolineSchedulerRule();

  @Mock CardRepository cardApiRepository;
  @Mock CardPresenter.View view;
  private Card card;

  @Before public void setup() {
    ArrayList<String> colors = new ArrayList<String>();
    colors.add("Green");
    colors.add("Blue");

    card = Card.newBuilder()
        .withId("cardId")
        .withName("CardName")
        .withImageUrl("http://image.url")
        .withArtist("Peter Pan")
        .withText("Lorem ipsum")
        .withSetName("International Spell")
        .withColors(colors)
        .build();
  }

  @Test public void shouldDisplayCardDetails() {
    Mockito.when(cardApiRepository.getCard("cardId")).thenReturn(Single.just(card));

    CardPresenter cardPresenter = new CardPresenter(cardApiRepository);
    cardPresenter.setView(view);

    cardPresenter.getCardDetails("cardId");

    Mockito.verify(view).setTitle(card.getName());
    Mockito.verify(view).setCardImage(card.getImageUrl());
    Mockito.verify(view).setArtistName(card.getArtist());
    Mockito.verify(view).setColors(ArrayListUtils.convertArrayListToString(card.getColors()));
    Mockito.verify(view).setSetName(card.getSetName());
    Mockito.verify(view).setText(card.getText());
  }
}
