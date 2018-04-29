package io.github.owuor91.data.repository.set;

import io.github.owuor91.data.mappers.SetMapper;
import io.github.owuor91.data.sql.dao.SetDao;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.models.Set;
import io.github.owuor91.domain.repository.SetRepository;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by johnowuor on 26/04/2018.
 */

public class SetDbRepository implements SetRepository {
  private SetDao SetDao;

  public SetDbRepository(SetDao SetDao) {
    this.SetDao = SetDao;
  }

  @Override public Single<List<Set>> getSets() {
    return SetDao.getAllSets().flatMapPublisher(Flowable::fromIterable).map(SetMapper::transformFromDb).toList();
  }

  @Override public Single<Set> getSet(String setId) {
    return SetDao.getSet(setId).map(SetMapper::transformFromDb);
  }

  @Override public Single<List<Card>> getBoosterPack(String setId) {
    return null;
  }

  @Override public Single<List<Set>> saveSets(List<Set> setList) {
    return Single.just(setList)
        .flatMapPublisher(Flowable::fromIterable)
        .map(SetMapper::transformToDb)
        .toList()
        .map(SetDao::insertSets)
        .map(longs -> setList);
  }
}
