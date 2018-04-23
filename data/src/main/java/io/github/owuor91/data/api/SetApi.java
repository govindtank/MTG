package io.github.owuor91.data.api;

import io.github.owuor91.data.models.api.responses.CardsResponse;
import io.github.owuor91.data.models.api.responses.SetResponse;
import io.github.owuor91.data.models.api.responses.SetsResponse;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by johnowuor on 23/04/2018.
 */

public interface SetApi {
  @GET("sets") Flowable<SetsResponse> getSets();

  @GET("sets/{id}") Flowable<SetResponse> getSet(@Path("id") String setId);

  @GET("sets/{id}/booster") Flowable<CardsResponse> getBoosterPack(@Path("id") String setId);
}
