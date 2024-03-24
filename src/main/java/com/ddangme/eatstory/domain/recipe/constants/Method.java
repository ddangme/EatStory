package com.ddangme.eatstory.domain.recipe.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Method {
    STIR_FRY("볶음"),
    BOIL("끓이기/삶기"),
    PAN_FRY("부침"),
    BRAISE("조림"),
    SEASONED("무침"),
    MIXED("비빔"),
    STEAM("찜"),
    PICKLE("절임"),
    FRY("튀김"),
    GRILL("굽기"),
    BLANCH("데치기"),
    RAW("회"),
    OTHER("기타");

    private final String method;

}

