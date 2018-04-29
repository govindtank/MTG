package io.github.owuor91.data.utils;

import android.util.Log;
import io.github.owuor91.domain.Constants;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by johnowuor on 26/04/2018.
 */

public class DateUtils {
  public static Date parseDate(String dateString) {
    DateFormat dateFormat = new SimpleDateFormat(Constants.YYYY_MM_DD);
    Date date = new Date();
    try {
      date = dateFormat.parse(dateString);
    } catch (ParseException p) {
      Log.e(Constants.SET_MAPPER_TAG, p.getMessage());
    }

    return date;
  }

  public static String convertToString(Date date){
    DateFormat dateFormat = new SimpleDateFormat(Constants.YYYY_MM_DD);
    return dateFormat.format(date);
  }
}
