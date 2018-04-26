package io.github.owuor91.presentation.sets;

import io.github.owuor91.data.utils.RxUtils;
import io.github.owuor91.domain.di.DIConstants;
import io.github.owuor91.domain.models.Set;
import io.github.owuor91.domain.repository.SetRepository;
import io.github.owuor91.presentation.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class SetsPresenter implements BasePresenter {
  private View view;
  private CompositeDisposable compositeDisposable;
  private SetRepository setApiRepository;

  @Inject public SetsPresenter(@Named(DIConstants.API) SetRepository setApiRepository) {
    this.setApiRepository = setApiRepository;
  }

  public void setView(View view) {
    this.view = view;
  }

  @Override public void dispose() {
    RxUtils.dispose(compositeDisposable);
  }

  public void fetchSets() {
    compositeDisposable = RxUtils.initDisposables(compositeDisposable);
    view.showProgress();

    Disposable disposable = setApiRepository.getSets()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSuccess(sets -> view.hideProgress())
        .doOnError(throwable -> view.hideProgress())
        .subscribe(view::displaySets, view::handleError);

    compositeDisposable.add(disposable);
  }

  public void onSetClick(Set set) {
    view.openSet(set.getCode(), set.getName());
  }

  public void onBoosterClick(Set set) {
    view.openBoosterPack(set.getCode(), set.getName());
  }

  public interface View extends BasePresenter.View {
    void showProgress();

    void hideProgress();

    void displaySets(List<Set> sets);

    void openSet(String setCode, String setName);

    void openBoosterPack(String setCode, String setName);
  }
}
