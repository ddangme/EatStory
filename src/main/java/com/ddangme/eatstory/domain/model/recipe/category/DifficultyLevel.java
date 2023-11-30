package com.ddangme.eatstory.domain.model.recipe.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DifficultyLevel {
    ANYONE("아무나"),
    BEGINNER("초급"),
    INTERMEDIATE("중급"),
    ADVANCED("고급"),
    MASTER("신의경지");

    private final String level;

    public static DifficultyLevel getDifficultyLevel(int index) {
        return DifficultyLevel.values()[index];
    }
}