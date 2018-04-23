package io.github.owuor91.data.models.api.responses;

import com.google.gson.annotations.SerializedName;
import io.github.owuor91.data.models.api.SetApiModel;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class SetResponse {
  @SerializedName("set") private SetApiModel setApiModel;

  public SetApiModel getSetApiModel() {
    return setApiModel;
  }

  public void setSetApiModel(SetApiModel setApiModel) {
    this.setApiModel = setApiModel;
  }
}
