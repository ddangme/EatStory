package com.ddangme.eatstory.domain.model.recipe.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IngredientType {
    BEEF("소고기"),
    PORK("돼지고기"),
    CHICKEN("닭고기"),
    MEAT("육류"),
    VEGETABLE("채소류"),
    SEAFOOD("해물류"),
    EGG_DAIRY("달걀/유제품"),
    PROCESSED_FOOD("가공식품류"),
    RICE("쌀"),
    FLOUR("밀가루"),
    DRIED_FISH("건어물류"),
    MUSHROOM("버섯류"),
    FRUIT("과일류"),
    BEAN_NUT("콩/견과류"),
    GRAIN("곡류"),
    OTHER("기타");

    private final String ingredient;

    public static IngredientType getIngredientType(int index) {
        return IngredientType.values()[index];
    }
}