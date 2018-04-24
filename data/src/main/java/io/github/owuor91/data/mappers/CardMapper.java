package io.github.owuor91.data.mappers;

import io.github.owuor91.data.models.api.CardApiModel;
import io.github.owuor91.domain.models.Card;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class CardMapper {
  public static Card transformFromApi(CardApiModel cardApiModel) {
    return Card.newBuilder()
        .withName(cardApiModel.getName())
        .withManaCost(cardApiModel.getManaCost())
        .withCmc(cardApiModel.getCmc())
        .withColors(cardApiModel.getColors())
        .withColorIdentity(cardApiModel.getColorIdentity())
        .withType(cardApiModel.getType())
        .withSupertypes(cardApiModel.getSupertypes())
        .withTypes(cardApiModel.getTypes())
        .withSubtypes(cardApiModel.getSubtypes())
        .withRarity(cardApiModel.getRarity())
        .withSet(cardApiModel.getSet())
        .withSetName(cardApiModel.getSetName())
        .withText(cardApiModel.getText())
        .withFlavor(cardApiModel.getFlavor())
        .withArtist(cardApiModel.getArtist())
        .withNumber(cardApiModel.getNumber())
        .withPower(cardApiModel.getPower())
        .withToughness(cardApiModel.getToughness())
        .withLayout(cardApiModel.getLayout())
        .withMultiverseid(cardApiModel.getMultiverseid())
        .withImageUrl(cardApiModel.getImageUrl())
        .withVariations(cardApiModel.getVariations())
        .withWatermark(cardApiModel.getWatermark())
        .withPrintings(cardApiModel.getPrintings())
        .withOriginalText(cardApiModel.getOriginalText())
        .withOriginalType(cardApiModel.getOriginalType())
        .withId(cardApiModel.getId())
        .build();
  }
}
