package io.github.owuor91.presentation.presentertests;

import io.github.owuor91.domain.models.Set;
import io.github.owuor91.domain.repository.SetRepository;
import io.github.owuor91.presentation.TrampolineSchedulerRule;
import io.github.owuor91.presentation.sets.SetsPresenter;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by johnowuor on 30/04/2018.
 */

@RunWith(MockitoJUnitRunner.class) public class SetPresenterTest {
  @Rule public final TrampolineSchedulerRule trampolineSchedulerRule = new TrampolineSchedulerRule();

  @Mock SetRepository setApiRepository;
  @Mock SetsPresenter.View view;

  @Test public void shouldDisplaySets() {
    List<Set> setsList = new ArrayList<Set>();
    setsList.add(Set.newBuilder().withCode("IST").withName("International").build());
    setsList.add(Set.newBuilder().withCode("KIM").withName("Turing").build());

    Mockito.when(setApiRepository.getSets()).thenReturn(Single.just(setsList));

    SetsPresenter setsPresenter = new SetsPresenter(setApiRepository);
    setsPresenter.setView(view);
    setsPresenter.fetchSets();

    Mockito.verify(view).displaySets(setsList);
  }
}
