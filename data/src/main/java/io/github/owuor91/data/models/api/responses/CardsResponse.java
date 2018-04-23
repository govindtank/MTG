package io.github.owuor91.data.models.api.responses;

import com.google.gson.annotations.SerializedName;
import io.github.owuor91.data.models.api.CardApiModel;
import java.util.List;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class CardsResponse {
  @SerializedName("cards") private List<CardApiModel> cardApiModels;

  public List<CardApiModel> getCardApiModels() {
    return cardApiModels;
  }

  public void setCardApiModels(List<CardApiModel> cardApiModels) {
    this.cardApiModels = cardApiModels;
  }
}
