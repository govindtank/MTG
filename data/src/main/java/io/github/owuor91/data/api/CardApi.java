package io.github.owuor91.data.api;

import io.github.owuor91.data.models.api.responses.CardResponse;
import io.github.owuor91.data.models.api.responses.CardsResponse;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by johnowuor on 23/04/2018.
 */

public interface CardApi {
  @GET("cards") Flowable<CardsResponse> getCards();

  @GET("cards/{id}") Flowable<CardResponse> getCard(@Path("id") String cardId);

  @GET("cards") Flowable<CardsResponse> getSetCards(@Query("set") String setCode);
}
