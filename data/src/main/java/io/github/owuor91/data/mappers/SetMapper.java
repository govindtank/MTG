package io.github.owuor91.data.mappers;

import android.util.Log;
import io.github.owuor91.data.models.api.SetApiModel;
import io.github.owuor91.domain.di.models.Set;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class SetMapper {

  public static final String SET_MAPPER_TAG = "SETMAPPERTAG";

  public static Set transformFromApi(SetApiModel setApiModel) {
    return Set.newBuilder()
        .withCode(setApiModel.getCode())
        .withName(setApiModel.getName())
        .withType(setApiModel.getType())
        .withBorder(setApiModel.getBorder())
        .withMkmId(setApiModel.getMkmId())
        .withBooster(setApiModel.getBooster())
        .withMkmName(setApiModel.getMkmName())
        .withReleaseDate(parseDate(setApiModel.getReleaseDate()))
        .withGathererCode(setApiModel.getGathererCode())
        .withMagicCardsInfoCode(setApiModel.getMagicCardsInfoCode())
        .withOnlineOnly(setApiModel.isOnlineOnly())
        .build();
  }

  public static Date parseDate(String dateString) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    try {
      date = dateFormat.parse(dateString);
    } catch (ParseException p) {
      Log.e(SET_MAPPER_TAG, p.getMessage());
    }

    return date;
  }
}
