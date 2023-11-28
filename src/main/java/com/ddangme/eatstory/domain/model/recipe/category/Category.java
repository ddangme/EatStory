package com.ddangme.eatstory.domain.model.recipe.category;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category {

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @Enumerated(EnumType.STRING)
    private SituationType situationType;

    @Enumerated(EnumType.STRING)
    private MethodType methodType;

    @Enumerated(EnumType.STRING)
    private IngredientType ingredientType;

    @Enumerated(EnumType.STRING)
    private FoodSize foodSize;

    @Enumerated(EnumType.STRING)
    private CookingTime cookingTime;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;
}
