package com.ddangme.eatstory.domain.recipe.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Time {
    LESS_5_MINUTES("5분 이내"),
    LESS_10_MINUTES("10분 이내"),
    LESS_15_MINUTES("15분 이내"),
    LESS_20_MINUTES("20분 이내"),
    LESS_30_MINUTES("30분 이내"),
    LESS_60_MINUTES("60분 이내"),
    LESS_90_MINUTES("90분 이내"),
    LESS_2_HOURS("2시간 이내"),
    MORE_2_HOURS("2시간 이상");

    private final String time;
    
}
