package com.ddangme.eatstory.web.controller;

import com.ddangme.eatstory.domain.model.recipe.category.*;
import com.ddangme.eatstory.web.form.recipe.RecipeIngredientWriteForm;
import com.ddangme.eatstory.web.form.recipe.RecipeWriteForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

    @GetMapping("write")
    public String RecipeDetailWriteForm(Model model) {
        addCategory(model);
        model.addAttribute("recipeWriteForm", new RecipeWriteForm());
        return "recipe/write";
    }

    @PostMapping("write")
    public String recipeWrite(@ModelAttribute RecipeWriteForm form, BindingResult bindingResult, Model model) {
        for (MultipartFile m : form.getFinalPhotos()) {
            System.out.println("file name: " + m.getOriginalFilename());
        }

        for (RecipeIngredientWriteForm ingredientWriteForm : form.getRecipeIngredientWriteForms()) {
            System.out.println(ingredientWriteForm.getCategory());
            for (String ingredient : ingredientWriteForm.getIngredients()) {
                System.out.println(ingredient);
            }
            for (String amount : ingredientWriteForm.getAmounts()) {
                System.out.println(amount);
            }
        }

        if (bindingResult.hasErrors()) {
            log.error("recipe write errors: {}", bindingResult);
            addCategory(model);
            return "recipe/write";
        }
        return "redirect:/";
    }

    private void addCategory(Model model) {
        model.addAttribute("foodTypes", List.of(FoodType.values()));
        model.addAttribute("situationTypes", List.of(SituationType.values()));
        model.addAttribute("methodTypes", List.of(MethodType.values()));
        model.addAttribute("ingredientTypes", List.of(IngredientType.values()));
        model.addAttribute("foodSizes", List.of(FoodSize.values()));
        model.addAttribute("cookingTimes", List.of(CookingTime.values()));
        model.addAttribute("difficultyLevels", List.of(DifficultyLevel.values()));
    }
}
