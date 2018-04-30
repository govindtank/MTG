package io.github.owuor91.data.mappers;

import io.github.owuor91.data.models.api.CardApiModel;
import io.github.owuor91.domain.models.Card;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by johnowuor on 30/04/2018.
 */

@RunWith(JUnit4.class) public class CardMapperTest {
  private CardApiModel cardApiModel;
  private ArrayList<String> colors, colorIdentity, supertypes, types, subtypes, printings;
  private ArrayList<Integer> variations;

  @Before public void setUp() {
    colors = new ArrayList<String>();
    colors.add("Black");
    colors.add("Yellow");

    colorIdentity = new ArrayList<String>();
    colorIdentity.add("identity1");
    colorIdentity.add("identity2");

    supertypes = new ArrayList<String>();
    supertypes.add("supertype1");
    supertypes.add("supertype2");

    types = new ArrayList<String>();
    types.add("type1");
    types.add("type2");

    subtypes = new ArrayList<String>();
    subtypes.add("subtype1");
    subtypes.add("subtype2");

    variations = new ArrayList<Integer>();
    variations.add(37482);
    variations.add(37826);

    printings = new ArrayList<String>();
    printings.add("printing1");
    printings.add("printing2");

    cardApiModel = CardApiModel.newBuilder()
        .withName("card name")
        .withManaCost("manacost")
        .withCmc(1.2)
        .withColors(colors)
        .withColorIdentity(colorIdentity)
        .withType("Type")
        .withSupertypes(supertypes)
        .withTypes(types)
        .withSubtypes(subtypes)
        .withRarity("very rare")
        .withSet("IGS")
        .withSetName("Inter Galactic Squad")
        .withText("Card text")
        .withFlavor("flavor")
        .withArtist("nicholo andrea")
        .withNumber("number")
        .withPower("power")
        .withToughness("toughness")
        .withLayout("layout")
        .withMultiverseid("multiverseId")
        .withImageUrl("http://image.url")
        .withVariations(variations)
        .withWatermark("watermark")
        .withPrintings(printings)
        .withOriginalText("original text")
        .withOriginalType("original type")
        .withId("hd7w828737hde7372gd23rgwdfjdwifassmoruve")
        .build();
  }

  @Test public void shouldConvertCardApiModelToCard() {
    Card myCard = CardMapper.transformFromApi(cardApiModel);

    Assert.assertEquals(myCard.getName(), cardApiModel.getName());
    Assert.assertEquals(myCard.getManaCost(), cardApiModel.getManaCost());
    Assert.assertEquals(myCard.getCmc(), cardApiModel.getCmc(), 0.0);
    Assert.assertEquals(myCard.getColors(), cardApiModel.getColors());
    Assert.assertEquals(myCard.getColorIdentity(), cardApiModel.getColorIdentity());
    Assert.assertEquals(myCard.getType(), cardApiModel.getType());
    Assert.assertEquals(myCard.getSupertypes(), cardApiModel.getSupertypes());
    Assert.assertEquals(myCard.getTypes(), cardApiModel.getTypes());
    Assert.assertEquals(myCard.getSubtypes(), cardApiModel.getSubtypes());
    Assert.assertEquals(myCard.getRarity(), cardApiModel.getRarity());
    Assert.assertEquals(myCard.getSet(), cardApiModel.getSet());
    Assert.assertEquals(myCard.getSetName(), cardApiModel.getSetName());
    Assert.assertEquals(myCard.getText(), cardApiModel.getText());
    Assert.assertEquals(myCard.getFlavor(), cardApiModel.getFlavor());
    Assert.assertEquals(myCard.getArtist(), cardApiModel.getArtist());
    Assert.assertEquals(myCard.getNumber(), cardApiModel.getNumber());
    Assert.assertEquals(myCard.getPower(), cardApiModel.getPower());
    Assert.assertEquals(myCard.getToughness(), cardApiModel.getToughness());
    Assert.assertEquals(myCard.getLayout(), cardApiModel.getLayout());
    Assert.assertEquals(myCard.getMultiverseid(), cardApiModel.getMultiverseid());
    Assert.assertEquals(myCard.getImageUrl(), cardApiModel.getImageUrl());
    Assert.assertEquals(myCard.getVariations(), cardApiModel.getVariations());
    Assert.assertEquals(myCard.getWatermark(), cardApiModel.getWatermark());
    Assert.assertEquals(myCard.getPrintings(), cardApiModel.getPrintings());
    Assert.assertEquals(myCard.getOriginalText(), cardApiModel.getOriginalText());
    Assert.assertEquals(myCard.getOriginalType(), cardApiModel.getOriginalType());
    Assert.assertEquals(myCard.getId(), cardApiModel.getId());
  }
}
