package com.ddangme.eatstory.domain.model.recipe;

import com.ddangme.eatstory.domain.model.UploadFile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class RecipeFinalImage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "recipe_final_image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Embedded
    private UploadFile uploadFile;

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
        recipe.getRecipeFinalImages().add(this);
    }
}
