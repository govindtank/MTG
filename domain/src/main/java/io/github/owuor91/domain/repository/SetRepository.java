package io.github.owuor91.domain.repository;

import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.models.Set;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by johnowuor on 23/04/2018.
 */

public interface SetRepository {
  Single<List<Set>> getSets();

  Single<Set> getSet(String setId);

  Single<List<Card>> getBoosterPack(String setId);
}
