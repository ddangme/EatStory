package com.ddangme.eatstory.domain.model.recipe.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MethodType {

    STIR_FRY("볶음"),
    STEW_SOUP("탕/국"),
    PAN_FRY("부침"),
    BRAISE("조림"),
    MIXED_RICE("비빔"),
    STEAM("찜"),
    PICKLE("절임"),
    DEEP_FRY("튀김"),
    BOIL("삶기"),
    GRILL("굽기"),
    PARBOIL("데치기"),
    RAW("회"),
    OTHER("기타");

    private final String method;
}
