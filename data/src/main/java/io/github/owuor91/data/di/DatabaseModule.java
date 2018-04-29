package io.github.owuor91.data.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.github.owuor91.data.sql.MTGDatabase;
import io.github.owuor91.data.sql.dao.CardDao;
import io.github.owuor91.data.sql.dao.SetDao;
import io.github.owuor91.domain.di.DIConstants;
import javax.inject.Named;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Module public class DatabaseModule {

  @Provides public MTGDatabase provideMTGDataBase(@Named(DIConstants.APP) Context context){
    return Room.databaseBuilder(context, MTGDatabase.class, "MTG_db").build();
  }

  @Provides public SetDao provideSetDao(MTGDatabase mtgDatabase){
    return mtgDatabase.mtgSetDao();
  }

  @Provides public CardDao provideCardDao(MTGDatabase mtgDatabase){
    return mtgDatabase.cardDao();
  }
}
