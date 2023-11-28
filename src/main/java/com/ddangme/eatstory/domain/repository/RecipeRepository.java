package com.ddangme.eatstory.domain.repository;

import com.ddangme.eatstory.domain.model.recipe.Recipe;
import com.ddangme.eatstory.domain.model.recipe.RecipeFinalImage;
import com.ddangme.eatstory.domain.model.recipe.RecipeStep;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecipeRepository {

    private final EntityManager em;

    public void saveRecipe(Recipe recipe) {
        em.persist(recipe);
    }

    public void saveRecipeStep(RecipeStep recipeStep) {
        em.persist(recipeStep);
    }

    public void saveRecipeFinalImage(RecipeFinalImage recipeFinalImage) {
        em.persist(recipeFinalImage);
    }

    public Recipe findRecipeById(Long id) {
        return em.find(Recipe.class, id);
    }

    public List<RecipeStep> findRecipeStepByRecipeId(Long recipeId) {
        return em.createQuery("SELECT rs FROM RecipeStep rs WHERE rs.recipe.id = :recipeId", RecipeStep.class)
                .setParameter("recipeId", recipeId)
                .getResultList();
    }

    public List<RecipeFinalImage> findRecipeFinalImageByRecipeId(Long recipeId) {
        return em.createQuery("SELECT ri FROM RecipeFinalImage ri WHERE ri.recipe.id = :recipeId", RecipeFinalImage.class)
                .setParameter("recipeId", recipeId)
                .getResultList();
    }
}
