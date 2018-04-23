package io.github.owuor91.presentation;

/**
 * Created by johnowuor on 23/04/2018.
 */

public interface BasePresenter {

  void dispose();

  interface View {
    void handleError(Throwable throwable);
  }
}
