package io.github.owuor91.domain.repository;

import io.github.owuor91.domain.models.Card;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by johnowuor on 23/04/2018.
 */

public interface CardRepository {
  Single<List<Card>> getCards();

  Single<Card> getCard(String cardId);

  Single<List<Card>> getSetCards(String setCode);
}
