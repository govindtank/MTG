package io.github.owuor91.data.sql.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import io.github.owuor91.data.models.db.SetDbModel;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by johnowuor on 26/04/2018.
 */

@Dao public interface SetDao {
  @Query("SELECT * FROM sets") Single<List<SetDbModel>> getAllSets();

  @Insert(onConflict = OnConflictStrategy.REPLACE) long[] insertSets(List<SetDbModel> setList);

  @Delete int deleteSets(List<SetDbModel> setList);

  @Query("SELECT * FROM sets WHERE code = :setCode") Single<SetDbModel> getSet(String setCode);
}
