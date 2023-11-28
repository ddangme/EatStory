package com.ddangme.eatstory.domain.model.recipe.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CookingTime {
    MIN_5("5분 이내"),
    MIN_10("10분 이내"),
    MIN_15("15분 이내"),
    MIN_20("20분 이내"),
    MIN_30("30분 이내"),
    MIN_60("60분 이내"),
    MIN_90("90분 이내"),
    MIN_120("2시간 이내"),
    OVER_MIN_120("2시간 이상");

    private final String time;

    public static CookingTime getCookingTime(int index) {
        return CookingTime.values()[index];
    }
}