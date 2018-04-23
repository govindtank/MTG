package io.github.owuor91.data.models.api.responses;

import com.google.gson.annotations.SerializedName;
import io.github.owuor91.data.models.api.SetApiModel;
import java.util.List;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class SetsResponse {
  @SerializedName("sets") private List<SetApiModel> setApiModels;

  public List<SetApiModel> getSetApiModels() {
    return setApiModels;
  }

  public void setSetApiModels(List<SetApiModel> setApiModels) {
    this.setApiModels = setApiModels;
  }
}
