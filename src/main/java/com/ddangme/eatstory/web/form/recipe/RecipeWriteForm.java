package com.ddangme.eatstory.web.form.recipe;

import com.ddangme.eatstory.domain.model.recipe.category.FoodType;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RecipeWriteForm {

    private MultipartFile mainPhoto;

    @NotBlank
    private String title;

    @NotBlank
    private String describe;


    private String videoLink;

    @NotNull
    private Integer foodType;
    @NotNull
    private Integer situationType;
    @NotNull
    private Integer methodType;
    @NotNull
    private Integer ingredientType;
    @NotNull
    private Integer foodSize;
    @NotNull
    private Integer cookingTime;
    @NotNull
    private Integer difficultyLevel;

    private String cookTips;

    private List<RecipeIngredientWriteForm> recipeIngredientWriteForms;

    private List<RecipeStepWriteForm> recipeStepWriteForms;

    private List<MultipartFile> finalPhotos;

}
