package io.github.owuor91.data.utils;

import io.github.owuor91.domain.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by johnowuor on 25/04/2018.
 */

public class ArrayListUtils {

  public static String convertArrayListToString(ArrayList<String> arrayList) {
    if (arrayList == null) return Constants.EMPTY_STRING;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < arrayList.size(); i++) {
      stringBuilder.append(arrayList.get(i));
      if ((i + 1) < arrayList.size()) {
        stringBuilder.append(Constants.COMMA_SPACE);
      }
    }
    return stringBuilder.toString();
  }

  public static ArrayList<String> convertStringToArrayList(String string) {
    List<String> list = Arrays.asList(string.split(Constants.COMMA));
    return new ArrayList<String>(list);
  }
}
