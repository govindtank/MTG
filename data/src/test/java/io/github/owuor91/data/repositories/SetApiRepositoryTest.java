package io.github.owuor91.data.repositories;

import io.github.owuor91.data.api.SetApi;
import io.github.owuor91.data.models.api.CardApiModel;
import io.github.owuor91.data.models.api.SetApiModel;
import io.github.owuor91.data.models.api.responses.CardsResponse;
import io.github.owuor91.data.models.api.responses.SetResponse;
import io.github.owuor91.data.models.api.responses.SetsResponse;
import io.github.owuor91.data.repository.set.SetApiRepository;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.models.Set;
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

@RunWith(MockitoJUnitRunner.class) public class SetApiRepositoryTest {
  @Mock SetApi setApi;
  private List<SetApiModel> setApiModels;
  private SetsResponse setsResponse;
  private SetResponse setResponse;
  private List<CardApiModel> cardApiModels;
  private CardsResponse cardsResponse;
  private SetApiRepository setApiRepository;

  @Before public void setup() {
    setApiModels = new ArrayList<SetApiModel>();
    setApiModels.add(SetApiModel.newBuilder().withCode("IST").withName("International").build());
    setApiModels.add(SetApiModel.newBuilder().withCode("UDV").withName("Distillers").build());
    setApiModels.add(SetApiModel.newBuilder().withCode("KAV").withName("Union").build());

    setsResponse = new SetsResponse(setApiModels);
    setResponse = new SetResponse(setApiModels.get(0));

    cardApiModels = new ArrayList<CardApiModel>();
    cardApiModels.add(CardApiModel.newBuilder().withId("dhu237").withName("Card 1").build());
    cardApiModels.add(CardApiModel.newBuilder().withId("h7432g").withName("Card 2").build());

    cardsResponse = new CardsResponse(cardApiModels);

    setApiRepository = new SetApiRepository(setApi);
  }

  @Test public void shouldFetchSets() {
    Mockito.when(setApi.getSets()).thenReturn(Flowable.just(setsResponse));

    TestObserver<List<Set>> testObserver = setApiRepository.getSets().test();
    testObserver.awaitTerminalEvent();

    testObserver.assertValue(setList -> setList.size() == 3);
  }

  @Test public void shouldFetchSet() {
    Mockito.when(setApi.getSet("IST")).thenReturn(Flowable.just(setResponse));

    TestObserver<Set> testObserver = setApiRepository.getSet("IST").test();
    testObserver.awaitTerminalEvent();

    testObserver.assertValue(set -> set.getName().equals("International"));
  }

  @Test public void shouldGetBoosterPack() {
    Mockito.when(setApi.getBoosterPack("IJD")).thenReturn(Flowable.just(cardsResponse));

    TestObserver<List<Card>> testObserver = setApiRepository.getBoosterPack("IJD").test();
    testObserver.awaitTerminalEvent();

    testObserver.assertValue(cardList -> cardList.size() == 2);
    testObserver.assertValue(cardList -> cardList.get(0).getName().equals("Card 1"));
  }
}
