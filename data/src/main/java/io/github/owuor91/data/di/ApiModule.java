package io.github.owuor91.data.di;

import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import io.github.owuor91.data.BuildConfig;
import io.github.owuor91.data.api.CardApi;
import io.github.owuor91.data.api.SetApi;
import io.github.owuor91.domain.di.DIConstants;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Module public class ApiModule {
  @Provides @Named(DIConstants.DEFAULT) public OkHttpClient provideDefaultOkHttpClient() {
    return new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .retryOnConnectionFailure(true)
        .build();
  }

  @Provides @Named(DIConstants.DEFAULT)
  public Retrofit provideDefaultRetrofit(Gson gson, @Named(DIConstants.DEFAULT) OkHttpClient okHttpClient) {
    return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build();
  }

  @Provides public CardApi provideCardApi(@Named(DIConstants.DEFAULT) Retrofit retrofit) {
    return retrofit.create(CardApi.class);
  }

  @Provides public SetApi provideSetApi(@Named(DIConstants.DEFAULT) Retrofit retrofit) {
    return retrofit.create(SetApi.class);
  }
}
