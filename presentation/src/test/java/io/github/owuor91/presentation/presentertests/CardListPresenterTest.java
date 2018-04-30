package io.github.owuor91.presentation.presentertests;

import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.repository.CardRepository;
import io.github.owuor91.domain.repository.SetRepository;
import io.github.owuor91.presentation.TrampolineSchedulerRule;
import io.github.owuor91.presentation.cards.CardsListPresenter;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
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

@RunWith(MockitoJUnitRunner.class) public class CardListPresenterTest {
  @Rule public final TrampolineSchedulerRule trampolineSchedulerRule = new TrampolineSchedulerRule();

  @Mock CardRepository cardApiRepository;
  @Mock SetRepository setApiRepository;
  @Mock CardsListPresenter.View view;
  CardsListPresenter cardsListPresenter;

  @Before public void setup() {
    cardsListPresenter = new CardsListPresenter(cardApiRepository, setApiRepository);
    cardsListPresenter.setView(view);
  }

  @Test public void shouldDisplaySetCardsList() {
    List<Card> cardsList = new ArrayList<Card>();
    cardsList.add(Card.newBuilder().withId("dhu237").withName("Card 1").build());

    Mockito.when(cardApiRepository.getSetCards("setCode")).thenReturn(Single.just(cardsList));

    cardsListPresenter.getSetCards("setCode");

    Mockito.verify(view).displayCards(cardsList);
  }

  @Test public void shouldDisplayBoosterPack() {
    List<Card> boosterPack = new ArrayList<Card>();
    boosterPack.add(Card.newBuilder().withId("h74rt62").withName("Cardi").withSet("UFO").build());

    Mockito.when(setApiRepository.getBoosterPack(boosterPack.get(0).getSet())).thenReturn(Single.just(boosterPack));

    cardsListPresenter.getBoosterPack("UFO");

    Mockito.verify(view).displayCards(boosterPack);
  }
}
