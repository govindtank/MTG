package io.github.owuor91.data.models.api.responses;

import com.google.gson.annotations.SerializedName;
import io.github.owuor91.data.models.api.CardApiModel;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class CardResponse {
  @SerializedName("card") private CardApiModel cardApiModel;

  public CardResponse(CardApiModel cardApiModel) {
    this.cardApiModel = cardApiModel;
  }

  public CardApiModel getCardApiModel() {
    return cardApiModel;
  }

  public void setCardApiModel(CardApiModel cardApiModel) {
    this.cardApiModel = cardApiModel;
  }
}
