package io.github.owuor91.data.repositories;

import io.github.owuor91.data.api.CardApi;
import io.github.owuor91.data.models.api.CardApiModel;
import io.github.owuor91.data.models.api.responses.CardResponse;
import io.github.owuor91.data.models.api.responses.CardsResponse;
import io.github.owuor91.data.repository.card.CardApiRepository;
import io.github.owuor91.domain.models.Card;
import io.reactivex.Flowable;
import io.reactivex.observers.TestObserver;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by johnowuor on 30/04/2018.
 */

@RunWith(MockitoJUnitRunner.class) public class CardApiRepositoryTest {
  @Mock CardApi cardApi;
  private List<CardApiModel> cardApiModels;
  private CardsResponse cardsResponse;
  private CardApiRepository cardApiRepository;
  private CardResponse cardResponse;

  @Before public void setUp() {
    cardApiModels = new ArrayList<CardApiModel>();
    cardApiModels.add(CardApiModel.newBuilder().withId("dhu237").withName("Card 1").build());
    cardApiModels.add(CardApiModel.newBuilder().withId("h7432g").withName("Card 2").build());
    cardApiModels.add(CardApiModel.newBuilder().withId("lw472f").withName("Card 3").build());
    cardApiModels.add(CardApiModel.newBuilder().withId("4y7w35").withName("Card 5").build());

    cardsResponse = new CardsResponse(cardApiModels);
    cardApiRepository = new CardApiRepository(cardApi);

    cardResponse = new CardResponse(cardApiModels.get(2));
  }

  @Test public void shouldFetchCards() {
    Mockito.when(cardApi.getCards()).thenReturn(Flowable.just(cardsResponse));

    TestObserver<List<Card>> testObserver = cardApiRepository.getCards().test();
    testObserver.awaitTerminalEvent();

    testObserver.assertValue(cardList -> cardList.size() == 4);
  }

  @Test public void shouldFetchCard() {
    Mockito.when(cardApi.getCard("lw472f")).thenReturn(Flowable.just(cardResponse));

    TestObserver<Card> testObserver = cardApiRepository.getCard("lw472f").test();
    testObserver.awaitTerminalEvent();

    testObserver.assertValue(card -> card.getName().equals("Card 3"));
  }

  @Test public void shouldFetchSetCards() {
    Mockito.when(cardApi.getSetCards("setCode")).thenReturn(Flowable.just(cardsResponse));

    TestObserver<List<Card>> testObserver = cardApiRepository.getSetCards("setCode").test();
    testObserver.awaitTerminalEvent();

    testObserver.assertValue(cardList -> cardList.size() == 4);
  }
}
