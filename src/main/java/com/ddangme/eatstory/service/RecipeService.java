package com.ddangme.eatstory.service;

import com.ddangme.eatstory.domain.model.recipe.Recipe;
import com.ddangme.eatstory.domain.model.recipe.RecipeFinalImage;
import com.ddangme.eatstory.domain.model.recipe.RecipeStep;
import com.ddangme.eatstory.domain.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Transactional
    public Long save(Recipe recipe, List<RecipeStep> recipeSteps, List<RecipeFinalImage> recipeFinalImages) {
        saveRecipe(recipe);
        saveRecipeStep(recipeSteps);
        saveRecipeFinalImages(recipeFinalImages);

        return recipe.getId();
    }

    private void saveRecipe(Recipe recipe) {
        recipeRepository.saveRecipe(recipe);
    }

    private void saveRecipeStep(List<RecipeStep> recipeSteps) {
        for (RecipeStep recipeStep : recipeSteps) {
            recipeRepository.saveRecipeStep(recipeStep);
        }
    }

    private void saveRecipeFinalImages(List<RecipeFinalImage> recipeFinalImages) {
        for (RecipeFinalImage recipeFinalImage : recipeFinalImages) {
            recipeRepository.saveRecipeFinalImage(recipeFinalImage);
        }
    }
}
