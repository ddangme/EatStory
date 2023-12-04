package com.ddangme.eatstory.web.form.recipe;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class RecipeIngredientWriteForm {

    private List<String> ingredients;
    private List<String> amounts;

    private String category;

    private String ingredient;

    private String amount;
}
