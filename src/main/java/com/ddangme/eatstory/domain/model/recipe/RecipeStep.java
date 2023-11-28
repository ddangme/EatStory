package com.ddangme.eatstory.domain.model.recipe;

import com.ddangme.eatstory.domain.model.UploadFile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class RecipeStep {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "recipe_step_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private String detail;

    @Embedded
    private RecipeTip recipeTip;

    @Embedded
    private UploadFile uploadFile;

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
        recipe.getRecipeSteps().add(this);
    }

}
