package com.ddangme.eatstory.domain.model.recipe.category;

import com.ddangme.eatstory.domain.model.recipe.Recipe;
import jakarta.persistence.*;
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

    public static Category getCategory(int foodType, int situationType, int methodType, int ingredientType) {
        Category category = new Category();
        category.foodType = FoodType.getFoodType(foodType);
        category.situationType = SituationType.getSituationType(situationType);
        category.methodType = MethodType.getMethodType(methodType);
        category.ingredientType = IngredientType.getIngredientType(ingredientType);

        return category;
    }
}
