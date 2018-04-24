package io.github.owuor91.data.models.api;

import java.util.ArrayList;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class CardApiModel {
  private String name;

  private String manaCost;

  private double cmc;

  private ArrayList<String> colors;

  private ArrayList<String> colorIdentity;

  private String type;

  private ArrayList<String> supertypes;

  private ArrayList<String> types;

  private ArrayList<String> subtypes;

  private String rarity;

  private String set;

  private String setName;

  private String text;

  private String flavor;

  private String artist;

  private String number;

  private String power;

  private String toughness;

  private String layout;

  private String multiverseid;

  private String imageUrl;

  private ArrayList<Integer> variations;

  private String watermark;

  private ArrayList<String> printings;

  private String originalText;

  private String originalType;

  private String id;

  public CardApiModel() {
  }

  private CardApiModel(Builder builder) {
    setName(builder.name);
    setManaCost(builder.manaCost);
    setCmc(builder.cmc);
    setColors(builder.colors);
    setColorIdentity(builder.colorIdentity);
    setType(builder.type);
    setSupertypes(builder.supertypes);
    setTypes(builder.types);
    setSubtypes(builder.subtypes);
    setRarity(builder.rarity);
    setSet(builder.set);
    setSetName(builder.setName);
    setText(builder.text);
    setFlavor(builder.flavor);
    setArtist(builder.artist);
    setNumber(builder.number);
    setPower(builder.power);
    setToughness(builder.toughness);
    setLayout(builder.layout);
    setMultiverseid(builder.multiverseid);
    setImageUrl(builder.imageUrl);
    setVariations(builder.variations);
    setWatermark(builder.watermark);
    setPrintings(builder.printings);
    setOriginalText(builder.originalText);
    setOriginalType(builder.originalType);
    setId(builder.id);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getManaCost() {
    return manaCost;
  }

  public void setManaCost(String manaCost) {
    this.manaCost = manaCost;
  }

  public double getCmc() {
    return cmc;
  }

  public void setCmc(double cmc) {
    this.cmc = cmc;
  }

  public ArrayList<String> getColors() {
    return colors;
  }

  public void setColors(ArrayList<String> colors) {
    this.colors = colors;
  }

  public ArrayList<String> getColorIdentity() {
    return colorIdentity;
  }

  public void setColorIdentity(ArrayList<String> colorIdentity) {
    this.colorIdentity = colorIdentity;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ArrayList<String> getSupertypes() {
    return supertypes;
  }

  public void setSupertypes(ArrayList<String> supertypes) {
    this.supertypes = supertypes;
  }

  public ArrayList<String> getTypes() {
    return types;
  }

  public void setTypes(ArrayList<String> types) {
    this.types = types;
  }

  public ArrayList<String> getSubtypes() {
    return subtypes;
  }

  public void setSubtypes(ArrayList<String> subtypes) {
    this.subtypes = subtypes;
  }

  public String getRarity() {
    return rarity;
  }

  public void setRarity(String rarity) {
    this.rarity = rarity;
  }

  public String getSet() {
    return set;
  }

  public void setSet(String set) {
    this.set = set;
  }

  public String getSetName() {
    return setName;
  }

  public void setSetName(String setName) {
    this.setName = setName;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getFlavor() {
    return flavor;
  }

  public void setFlavor(String flavor) {
    this.flavor = flavor;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getPower() {
    return power;
  }

  public void setPower(String power) {
    this.power = power;
  }

  public String getToughness() {
    return toughness;
  }

  public void setToughness(String toughness) {
    this.toughness = toughness;
  }

  public String getLayout() {
    return layout;
  }

  public void setLayout(String layout) {
    this.layout = layout;
  }

  public String getMultiverseid() {
    return multiverseid;
  }

  public void setMultiverseid(String multiverseid) {
    this.multiverseid = multiverseid;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public ArrayList<Integer> getVariations() {
    return variations;
  }

  public void setVariations(ArrayList<Integer> variations) {
    this.variations = variations;
  }

  public String getWatermark() {
    return watermark;
  }

  public void setWatermark(String watermark) {
    this.watermark = watermark;
  }

  public ArrayList<String> getPrintings() {
    return printings;
  }

  public void setPrintings(ArrayList<String> printings) {
    this.printings = printings;
  }

  public String getOriginalText() {
    return originalText;
  }

  public void setOriginalText(String originalText) {
    this.originalText = originalText;
  }

  public String getOriginalType() {
    return originalType;
  }

  public void setOriginalType(String originalType) {
    this.originalType = originalType;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public static final class Builder {
    private String name;
    private String manaCost;
    private double cmc;
    private ArrayList<String> colors;
    private ArrayList<String> colorIdentity;
    private String type;
    private ArrayList<String> supertypes;
    private ArrayList<String> types;
    private ArrayList<String> subtypes;
    private String rarity;
    private String set;
    private String setName;
    private String text;
    private String flavor;
    private String artist;
    private String number;
    private String power;
    private String toughness;
    private String layout;
    private String multiverseid;
    private String imageUrl;
    private ArrayList<Integer> variations;
    private String watermark;
    private ArrayList<String> printings;
    private String originalText;
    private String originalType;
    private String id;

    private Builder() {
    }

    public Builder withName(String val) {
      name = val;
      return this;
    }

    public Builder withManaCost(String val) {
      manaCost = val;
      return this;
    }

    public Builder withCmc(double val) {
      cmc = val;
      return this;
    }

    public Builder withColors(ArrayList<String> val) {
      colors = val;
      return this;
    }

    public Builder withColorIdentity(ArrayList<String> val) {
      colorIdentity = val;
      return this;
    }

    public Builder withType(String val) {
      type = val;
      return this;
    }

    public Builder withSupertypes(ArrayList<String> val) {
      supertypes = val;
      return this;
    }

    public Builder withTypes(ArrayList<String> val) {
      types = val;
      return this;
    }

    public Builder withSubtypes(ArrayList<String> val) {
      subtypes = val;
      return this;
    }

    public Builder withRarity(String val) {
      rarity = val;
      return this;
    }

    public Builder withSet(String val) {
      set = val;
      return this;
    }

    public Builder withSetName(String val) {
      setName = val;
      return this;
    }

    public Builder withText(String val) {
      text = val;
      return this;
    }

    public Builder withFlavor(String val) {
      flavor = val;
      return this;
    }

    public Builder withArtist(String val) {
      artist = val;
      return this;
    }

    public Builder withNumber(String val) {
      number = val;
      return this;
    }

    public Builder withPower(String val) {
      power = val;
      return this;
    }

    public Builder withToughness(String val) {
      toughness = val;
      return this;
    }

    public Builder withLayout(String val) {
      layout = val;
      return this;
    }

    public Builder withMultiverseid(String val) {
      multiverseid = val;
      return this;
    }

    public Builder withImageUrl(String val) {
      imageUrl = val;
      return this;
    }

    public Builder withVariations(ArrayList<Integer> val) {
      variations = val;
      return this;
    }

    public Builder withWatermark(String val) {
      watermark = val;
      return this;
    }

    public Builder withPrintings(ArrayList<String> val) {
      printings = val;
      return this;
    }

    public Builder withOriginalText(String val) {
      originalText = val;
      return this;
    }

    public Builder withOriginalType(String val) {
      originalType = val;
      return this;
    }

    public Builder withId(String val) {
      id = val;
      return this;
    }

    public CardApiModel build() {
      return new CardApiModel(this);
    }
  }
}
