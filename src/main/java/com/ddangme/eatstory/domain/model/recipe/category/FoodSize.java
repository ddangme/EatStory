package com.ddangme.eatstory.domain.model.recipe.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodSize {
    ONE_SERVING("1인분"),
    TWO_SERVINGS("2인분"),
    THREE_SERVINGS("3인분"),
    FOUR_SERVINGS("4인분"),
    FIVE_SERVINGS("5인분"),
    OVER_SIX_SERVINGS("6인분 이상");

    private final String size;

    public static FoodSize getFoodSize(int index) {
        return FoodSize.values()[index];
    }

}