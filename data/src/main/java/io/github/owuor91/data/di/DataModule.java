package io.github.owuor91.data.di;

import dagger.Module;

/**
 * Created by johnowuor on 23/04/2018.
 */

@Module(includes = { ApiModule.class, DatabaseModule.class, RepositoryModule.class }) public class DataModule {
}
