package com.ddangme.eatstory.domain.model.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RecipeStatus {
    DRAFT("임시저장"),
    PROHIBITED("제지"),
    NORMAL("정상");

    private final String status;
}
