package com.laioffer.jupiter.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// json string to object 的时候 match 不上就ignore
@JsonIgnoreProperties(ignoreUnknown = true)
//JsonJsonInclude.Include.NON_NULL这个最常用，即如果加该注解的字段为null,那么就不序列化这个字段了。
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = Item.Builder.class)
public class Item {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("title")
    private final String title;
    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;
    @JsonProperty("broadcaster_name")
    // 别名
    @JsonAlias({ "user_name" })
    private String broadcasterName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("game_id")
    private String gameId;
    // enum ??
    @JsonProperty("item_type")
    private ItemType type;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getBroadcasterName() {
        return broadcasterName;
    }

    public String getUrl() {
        return url;
    }

    public String getGameId() {
        return gameId;
    }

    public ItemType getType() {
        return type;
    }

    public Item setUrl(String url) {
        this.url = url;
        return this;
    }

    public Item setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public Item setType(ItemType type) {
        this.type = type;
        return this;
    }

    private Item(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.url = builder.url;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.broadcasterName = builder.broadcasterName;
        this.gameId = builder.gameId;
        this.type = builder.type;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Builder {
        @JsonProperty("id")
        private String id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("thumbnail_url")
        private String thumbnailUrl;
        @JsonProperty("broadcaster_name")
        @JsonAlias({ "user_name" })
        private String broadcasterName;
        @JsonProperty("url")
        private String url;
        @JsonProperty("game_id")
        private String gameId;
        @JsonProperty("item_type")
        private ItemType type;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public Builder setBroadcasterName(String broadcasterName) {
            this.broadcasterName = broadcasterName;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setGameId(String gameId) {
            this.gameId = gameId;
            return this;
        }

        public Builder setType(ItemType type) {
            this.type = type;
            return this;
        }
        public Item build() {
            return new Item(this);
        }
    }
}
