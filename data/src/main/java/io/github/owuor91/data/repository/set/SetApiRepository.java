package io.github.owuor91.data.repository.set;

import io.github.owuor91.data.api.SetApi;
import io.github.owuor91.data.mappers.CardMapper;
import io.github.owuor91.data.mappers.SetMapper;
import io.github.owuor91.data.models.api.responses.CardsResponse;
import io.github.owuor91.data.models.api.responses.SetResponse;
import io.github.owuor91.data.models.api.responses.SetsResponse;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.models.Set;
import io.github.owuor91.domain.repository.SetRepository;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class SetApiRepository implements SetRepository {
  private SetApi setApi;

  public SetApiRepository(SetApi setApi) {
    this.setApi = setApi;
  }

  @Override public Single<List<Set>> getSets() {
    return setApi.getSets()
        .map(SetsResponse::getSetApiModels)
        .flatMap(Flowable::fromIterable)
        .map(SetMapper::transformFromApi)
        .toList();
  }

  @Override public Single<Set> getSet(String setId) {
    return setApi.getSet(setId).map(SetResponse::getSetApiModel).map(SetMapper::transformFromApi).firstOrError();
  }

  @Override public Single<List<Card>> getBoosterPack(String setId) {
    return setApi.getBoosterPack(setId)
        .map(CardsResponse::getCardApiModels)
        .flatMap(Flowable::fromIterable)
        .map(CardMapper::transformFromApi)
        .toList();
  }
}
