package io.github.owuor91.data.mappers;

import android.util.Log;
import io.github.owuor91.data.models.api.SetApiModel;
import io.github.owuor91.domain.Constants;
import io.github.owuor91.domain.models.Set;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

  public static Date parseDate(String dateString) {
    if (dateString == null || dateString.equals(Constants.EMPTY_STRING)) return new Date();
    DateFormat dateFormat = new SimpleDateFormat(Constants.YYYY_MM_DD);
    Date date = new Date();
    try {
      date = dateFormat.parse(dateString);
    } catch (ParseException p) {
      Log.e(Constants.SET_MAPPER_TAG, p.getMessage());
    }

    return date;
  }
}
