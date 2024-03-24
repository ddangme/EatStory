package com.ddangme.eatstory.domain.recipe.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum People {
    ONE("1인분"),
    TWO("2인분"),
    THREE("3인분"),
    FOUR("4인분"),
    FIVE("5인분"),
    MORE_SIX("6인분 이상");

    private final String people;
}
