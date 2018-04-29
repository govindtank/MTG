package io.github.owuor91.data.mappers;

import android.util.Log;
import io.github.owuor91.data.models.api.SetApiModel;
import io.github.owuor91.data.models.db.SetDbModel;
import io.github.owuor91.domain.Constants;
import io.github.owuor91.domain.models.Set;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.github.owuor91.data.utils.DateUtils.convertToString;
import static io.github.owuor91.data.utils.DateUtils.parseDate;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class SetMapper {

  public static Set transformFromApi(SetApiModel setApiModel) {
    return Set.newBuilder()
        .withCode(setApiModel.getCode())
        .withName(setApiModel.getName())
        .withType(setApiModel.getType())
        .withBorder(setApiModel.getBorder())
        .withMkmId(setApiModel.getMkmId())
        .withMkmName(setApiModel.getMkmName())
        .withReleaseDate(parseDate(setApiModel.getReleaseDate()))
        .withGathererCode(setApiModel.getGathererCode())
        .withMagicCardsInfoCode(setApiModel.getMagicCardsInfoCode())
        .withOnlineOnly(setApiModel.isOnlineOnly())
        .build();
  }

  public static SetDbModel transformToDb(Set set){
    return SetDbModel.newBuilder()
        .withCode(set.getCode())
        .withName(set.getName())
        .withType(set.getType())
        .withBorder(set.getBorder())
        .withMkmId(set.getMkmId())
        .withMkmName(set.getMkmName())
        .withReleaseDate(convertToString(set.getReleaseDate()))
        .withGathererCode(set.getGathererCode())
        .withMagicCardsInfoCode(set.getMagicCardsInfoCode())
        .withOnlineOnly(set.isOnlineOnly())
        .build();
  }

  public static Set transformFromDb(SetDbModel setDbModel){
    return Set.newBuilder()
        .withCode(setDbModel.getCode())
        .withName(setDbModel.getName())
        .withType(setDbModel.getType())
        .withBorder(setDbModel.getBorder())
        .withMkmId(setDbModel.getMkmId())
        .withMkmName(setDbModel.getMkmName())
        .withReleaseDate(parseDate(setDbModel.getReleaseDate()))
        .withGathererCode(setDbModel.getGathererCode())
        .withMagicCardsInfoCode(setDbModel.getMagicCardsInfoCode())
        .withOnlineOnly(setDbModel.isOnlineOnly())
        .build();
  }


}
