package io.github.owuor91.presentation.di;

import dagger.Module;
import io.github.owuor91.data.di.DataModule;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Module(includes = { DataModule.class }) public class PresenterModule {
}
