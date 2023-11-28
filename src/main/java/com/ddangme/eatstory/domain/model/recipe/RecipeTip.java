package com.ddangme.eatstory.domain.model.recipe;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RecipeTip {
    private String ingredient;
    private String tool;
    private String fire;
    private String tip;
}
