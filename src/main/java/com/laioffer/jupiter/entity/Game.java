package com.laioffer.jupiter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// avoid the field can't match
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

// tell jackson using builder create object   (json string to java object)
@JsonDeserialize(builder = Game.Builder.class)

public class Game {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("box_art_url")
    private final String box_art_url;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBox_art_url() {
        return box_art_url;
    }

    public Game(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.box_art_url = builder.box_art_url;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)

    public static class Builder {
        @JsonProperty("id")
        String id;
        @JsonProperty("name")
        String name;
        @JsonProperty("box_art_url")
        String box_art_url;

        public Builder setBox_art_url(String box_art_url) {
            this.box_art_url = box_art_url;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }
}
