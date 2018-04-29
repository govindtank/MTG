package io.github.owuor91.data.di;

import dagger.Module;
import dagger.Provides;
import io.github.owuor91.data.api.CardApi;
import io.github.owuor91.data.api.SetApi;
import io.github.owuor91.data.repository.card.CardApiRepository;
import io.github.owuor91.data.repository.set.SetApiRepository;
import io.github.owuor91.data.repository.set.SetDbRepository;
import io.github.owuor91.data.sql.dao.SetDao;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.domain.repository.CardRepository;
import io.github.owuor91.domain.repository.SetRepository;
import javax.inject.Named;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Module public class RepositoryModule {
  @Provides @Named(DIConstants.API) SetRepository provideSetApiRepository(SetApi setApi,
      @Named(DIConstants.DB) SetRepository setDbRepository) {
    return new SetApiRepository(setApi, setDbRepository);
  }

  @Provides @Named(DIConstants.API) CardRepository provideCardApiRepository(CardApi cardApi) {
    return new CardApiRepository(cardApi);
  }

  @Provides @Named(DIConstants.DB) SetRepository provideSetDbRepository(SetDao SetDao) {
    return new SetDbRepository(SetDao);
  }
}
