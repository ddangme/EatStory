package com.ddangme.eatstory.domain.recipe.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Situation {
    DAILY("일상"),
    HIGH_SPEED("초스피드"),
    ENTERTAINING_GUESTS("손님접대"),
    ALCOHOL_SNACK("술안주"),
    DIET("다이어트"),
    LUNCH_BOX("도시락"),
    NUTRITIONAL_MEAL("영양식"),
    SNACK("간식"),
    LATE_NIGHT_SNACK("야식"),
    FOOD_STYLING("푸드스타일링"),
    HANGOVER_CURE("해장"),
    HOLIDAY("명절"),
    BABY_FOOD("이유식"),
    OTHER("기타");

    private final String situation;
}
