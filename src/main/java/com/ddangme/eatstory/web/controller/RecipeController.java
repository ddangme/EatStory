package com.ddangme.eatstory.web.controller;

import com.ddangme.eatstory.domain.model.recipe.category.*;
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

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

    @GetMapping("write")
    public String recipeWriteForm(Model model) {
        addCategory(model);
        model.addAttribute("recipeWriteForm", new RecipeWriteForm());
        return "recipe/write";
    }

    @PostMapping("write")
    public String recipeWrite(@Validated @ModelAttribute RecipeWriteForm form, BindingResult bindingResult, Model model) {

        System.out.println(form.getFoodType());
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
