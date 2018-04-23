package io.github.owuor91.mtg.di.app;

import android.content.Context;
import dagger.Module;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Module public class AndroidModule {
  private Context context;

  public AndroidModule(Context context) {
    this.context = context;
  }
}
