package io.github.owuor91.presentation.cards;

import io.github.owuor91.data.utils.RxUtils;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.repository.CardRepository;
import io.github.owuor91.presentation.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by johnowuor on 25/04/2018.
 */

public class CardPresenter implements BasePresenter {
  private CompositeDisposable compositeDisposable;
  private View view;
  private CardRepository cardApiRepository;

  @Inject public CardPresenter(@Named(DIConstants.API) CardRepository cardApiRepository) {
    this.cardApiRepository = cardApiRepository;
  }

  public void setView(View view) {
    this.view = view;
  }

  public void getCardDetails(String cardId) {
    compositeDisposable = RxUtils.initDisposables(compositeDisposable);

    Disposable disposable = cardApiRepository.getCard(cardId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnError(throwable -> view.hideProgress())
        .doOnSuccess(card -> view.hideProgress())
        .subscribe(view::displayCardDetails, view::handleError);

    compositeDisposable.add(disposable);
  }

  @Override public void dispose() {
    RxUtils.dispose(compositeDisposable);
  }

  public interface View extends BasePresenter.View {
    void showProgress();

    void hideProgress();

    void displayCardDetails(Card card);
  }
}
