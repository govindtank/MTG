package io.github.owuor91.data.utils;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class RxUtils {
  public static CompositeDisposable initDisposables(CompositeDisposable compositeDisposable) {
    if (compositeDisposable == null || (compositeDisposable != null && compositeDisposable.isDisposed())) {
      return new CompositeDisposable();
    }

    return compositeDisposable;
  }

  public static void dispose(CompositeDisposable compositeDisposable) {
    if (compositeDisposable != null) {
      compositeDisposable.dispose();
    }
  }
}
