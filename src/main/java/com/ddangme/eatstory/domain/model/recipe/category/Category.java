package com.ddangme.eatstory.domain.model.recipe.category;

import com.ddangme.eatstory.domain.model.recipe.Recipe;
import jakarta.persistence.*;
import lombok.*;

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
    
    @Builder
    public Category(Integer foodType, Integer situationType, Integer methodType, 
                    Integer ingredientType, Integer foodSize, Integer cookingTime,
                    Integer difficultyLevel) {
        this.foodType = FoodType.getFoodType(foodType);
        this.situationType = SituationType.getSituationType(situationType);
        this.methodType = MethodType.getMethodType(methodType);
        this.ingredientType = IngredientType.getIngredientType(ingredientType);
        this.foodSize = FoodSize.getFoodSize(foodSize);
        this.cookingTime = CookingTime.getCookingTime(cookingTime);
        this.difficultyLevel = DifficultyLevel.getDifficultyLevel(difficultyLevel);
    }
}
