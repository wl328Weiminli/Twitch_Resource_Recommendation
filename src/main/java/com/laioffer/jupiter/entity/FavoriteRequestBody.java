package com.laioffer.jupiter.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


// 创建一个接受post map json to object   不然要先转成 Object （使用 JSONObject） 然后取出favorite map 成 Item
public class FavoriteRequestBody {
    private final Item favoriteItem;


    //告诉 Jackson 用那个constructor   转换单向 写在 cons 里面
    @JsonCreator
    public FavoriteRequestBody(@JsonProperty("favorite") Item favoriteItem) {
        this.favoriteItem = favoriteItem;
    }

    public Item getFavoriteItem() {
        return favoriteItem;
    }
}
