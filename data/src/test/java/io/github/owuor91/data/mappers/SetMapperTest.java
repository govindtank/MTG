package io.github.owuor91.data.mappers;

import io.github.owuor91.data.models.api.SetApiModel;
import io.github.owuor91.domain.models.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by johnowuor on 30/04/2018.
 */

@RunWith(JUnit4.class) public class SetMapperTest {
  private SetApiModel setApiModel;
  private Set set;

  @Before public void setup() {
    setApiModel = SetApiModel.newBuilder()
        .withCode("abc")
        .withName("alphabet")
        .withType("type")
        .withBorder("blue")
        .withMkmId(345)
        .withMkmName("mkm name")
        .withReleaseDate("1995-06-25")
        .withGathererCode("gatherercode")
        .withMagicCardsInfoCode("mcic")
        .withOnlineOnly(false)
        .build();

    set = Set.newBuilder()
        .withCode("abc")
        .withName("alphabet")
        .withType("type")
        .withBorder("blue")
        .withMkmId(345)
        .withMkmName("mkm name")
        .withReleaseDate(SetMapper.parseDate("1995-06-25"))
        .withGathererCode("gatherercode")
        .withMagicCardsInfoCode("mcic")
        .withOnlineOnly(false)
        .build();
  }

  @Test public void shouldConvertSetApiModelToSet() {
    Set mySet = SetMapper.transformFromApi(setApiModel);

    Assert.assertEquals(mySet.getCode(), setApiModel.getCode());
    Assert.assertEquals(mySet.getName(), setApiModel.getName());
    Assert.assertEquals(mySet.getType(), setApiModel.getType());
    Assert.assertEquals(mySet.getBorder(), setApiModel.getBorder());
    Assert.assertEquals(mySet.getMkmId(), setApiModel.getMkmId());
    Assert.assertEquals(mySet.getMkmName(), setApiModel.getMkmName());
    Assert.assertEquals(mySet.getReleaseDate(), SetMapper.parseDate(setApiModel.getReleaseDate()));
    Assert.assertEquals(mySet.getGathererCode(), setApiModel.getGathererCode());
    Assert.assertEquals(mySet.getMagicCardsInfoCode(), setApiModel.getMagicCardsInfoCode());
    Assert.assertEquals(mySet.isOnlineOnly(), setApiModel.isOnlineOnly());
  }
}
