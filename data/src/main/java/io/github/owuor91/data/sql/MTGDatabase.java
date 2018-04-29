package io.github.owuor91.data.sql;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import io.github.owuor91.data.models.db.CardDbModel;
import io.github.owuor91.data.models.db.SetDbModel;
import io.github.owuor91.data.sql.dao.CardDao;
import io.github.owuor91.data.sql.dao.SetDao;

/**
 * Created by johnowuor on 26/04/2018.
 */

@Database(entities = { SetDbModel.class, CardDbModel.class }, version = 1) public abstract class MTGDatabase
    extends RoomDatabase {
  public abstract SetDao mtgSetDao();

  public abstract CardDao cardDao();
}
