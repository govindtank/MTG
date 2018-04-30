package io.github.owuor91.presentation.cards;

import io.github.owuor91.data.utils.RxUtils;
import io.github.owuor91.domain.Constants;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.domain.models.Card;
import io.github.owuor91.domain.repository.CardRepository;
import io.github.owuor91.domain.repository.SetRepository;
import io.github.owuor91.presentation.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import retrofit2.HttpException;

/**
 * Created by johnowuor on 24/04/2018.
 */

public class CardsListPresenter implements BasePresenter {
  private View view;
  private CompositeDisposable compositeDisposable;
  private CardRepository cardApiRepository;
  private SetRepository setApiRepository;

  @Inject public CardsListPresenter(@Named(DIConstants.API) CardRepository cardApiRepository,
      @Named(DIConstants.API) SetRepository setApiRepository) {
    this.cardApiRepository = cardApiRepository;
    this.setApiRepository = setApiRepository;
  }

  public void setView(View view) {
    this.view = view;
  }

  @Override public void dispose() {
    RxUtils.dispose(compositeDisposable);
  }

  public void getSetCards(String setCode) {
    compositeDisposable = RxUtils.initDisposables(compositeDisposable);
    view.showProgress();

    Disposable disposable = cardApiRepository.getSetCards(setCode)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSuccess(cardList -> view.hideProgress())
        .doOnError(throwable -> view.hideProgress()).subscribe(view::displayCards, view::handleError);

    compositeDisposable.add(disposable);
  }

  public void onClickCard(String cardId) {
    view.openCard(cardId);
  }

  public void fetchCards(boolean mFetchBooster, String setCode) {
    if (mFetchBooster) {
      view.setBoosterPackTitle();
      getBoosterPack(setCode);
    } else {
      view.setCardsTitle();
      getSetCards(setCode);
    }
  }

  public void getBoosterPack(String setCode) {
    compositeDisposable = RxUtils.initDisposables(compositeDisposable);
    view.showProgress();

    Disposable disposable = setApiRepository.getBoosterPack(setCode)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSuccess(cardList -> view.hideProgress())
        .doOnError(throwable -> view.hideProgress()).subscribe(view::displayCards, throwable -> {
          if (throwable instanceof HttpException && ((HttpException) throwable).code() == Constants.HTTP_ERROR_400) {
            view.showEmptyState();
          } else {
            view.handleError(throwable);
          }
        });

    compositeDisposable.add(disposable);
  }

  public interface View extends BasePresenter.View {
    void displayCards(List<Card> cardList);

    void showProgress();

    void hideProgress();

    void setCardsTitle();

    void setBoosterPackTitle();

    void openCard(String cardId);

    void showEmptyState();
  }
}
