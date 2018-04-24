package io.github.owuor91.data.repository.card;

import io.github.owuor91.data.api.CardApi;
import io.github.owuor91.data.mappers.CardMapper;
import io.github.owuor91.data.models.api.responses.CardResponse;
import io.github.owuor91.data.models.api.responses.CardsResponse;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.repository.CardRepository;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class CardApiRepository implements CardRepository {
  private CardApi cardApi;

  public CardApiRepository(CardApi cardApi) {
    this.cardApi = cardApi;
  }

  @Override public Single<List<Card>> getCards() {
    return cardApi.getCards()
        .map(CardsResponse::getCardApiModels)
        .flatMap(Flowable::fromIterable)
        .map(CardMapper::transformFromApi)
        .toList();
  }

  @Override public Single<Card> getCard(String cardId) {
    return cardApi.getCard(cardId).map(CardResponse::getCardApiModel).map(CardMapper::transformFromApi).firstOrError();
  }

  @Override public Single<List<Card>> getSetCards(String setCode) {
    return cardApi.getSetCards(setCode)
        .map(CardsResponse::getCardApiModels)
        .flatMap(Flowable::fromIterable)
        .map(CardMapper::transformFromApi)
        .toList();
  }
}
