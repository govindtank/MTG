package io.github.owuor91.data.models.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johnowuor on 23/04/2018.
 */

public class SetApiModel {
  private String code;

  private String name;

  private String type;

  private String border;

  @SerializedName("mkm_id") private int mkmId;

  @SerializedName("mkm_name") private String mkmName;

  private String releaseDate;

  private String gathererCode;

  private String magicCardsInfoCode;

  private boolean onlineOnly;

  public SetApiModel() {
  }

  private SetApiModel(Builder builder) {
    setCode(builder.code);
    setName(builder.name);
    setType(builder.type);
    setBorder(builder.border);
    setMkmId(builder.mkmId);
    setMkmName(builder.mkmName);
    setReleaseDate(builder.releaseDate);
    setGathererCode(builder.gathererCode);
    setMagicCardsInfoCode(builder.magicCardsInfoCode);
    setOnlineOnly(builder.onlineOnly);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getBorder() {
    return border;
  }

  public void setBorder(String border) {
    this.border = border;
  }

  public int getMkmId() {
    return mkmId;
  }

  public void setMkmId(int mkmId) {
    this.mkmId = mkmId;
  }

  public String getMkmName() {
    return mkmName;
  }

  public void setMkmName(String mkmName) {
    this.mkmName = mkmName;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getGathererCode() {
    return gathererCode;
  }

  public void setGathererCode(String gathererCode) {
    this.gathererCode = gathererCode;
  }

  public String getMagicCardsInfoCode() {
    return magicCardsInfoCode;
  }

  public void setMagicCardsInfoCode(String magicCardsInfoCode) {
    this.magicCardsInfoCode = magicCardsInfoCode;
  }

  public boolean isOnlineOnly() {
    return onlineOnly;
  }

  public void setOnlineOnly(boolean onlineOnly) {
    this.onlineOnly = onlineOnly;
  }

  public static final class Builder {
    private String code;
    private String name;
    private String type;
    private String border;
    private int mkmId;
    private String mkmName;
    private String releaseDate;
    private String gathererCode;
    private String magicCardsInfoCode;
    private boolean onlineOnly;

    private Builder() {
    }

    public Builder withCode(String val) {
      code = val;
      return this;
    }

    public Builder withName(String val) {
      name = val;
      return this;
    }

    public Builder withType(String val) {
      type = val;
      return this;
    }

    public Builder withBorder(String val) {
      border = val;
      return this;
    }

    public Builder withMkmId(int val) {
      mkmId = val;
      return this;
    }

    public Builder withMkmName(String val) {
      mkmName = val;
      return this;
    }

    public Builder withReleaseDate(String val) {
      releaseDate = val;
      return this;
    }

    public Builder withGathererCode(String val) {
      gathererCode = val;
      return this;
    }

    public Builder withMagicCardsInfoCode(String val) {
      magicCardsInfoCode = val;
      return this;
    }

    public Builder withOnlineOnly(boolean val) {
      onlineOnly = val;
      return this;
    }

    public SetApiModel build() {
      return new SetApiModel(this);
    }
  }
}
