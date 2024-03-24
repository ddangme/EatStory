package com.ddangme.eatstory.domain.recipe.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Degree {
    ANYONE("아무나"),
    BEGINNER("초급"),
    INTERMEDIATE("중급"),
    ADVANCED("고급"),
    MASTER("신의 경지");

    private final String degree;
}
