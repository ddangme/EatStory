package com.ddangme.eatstory.web.controller;

import com.ddangme.eatstory.domain.model.recipe.category.FoodType;
import com.ddangme.eatstory.domain.model.recipe.category.SituationType;
import com.ddangme.eatstory.web.form.recipe.RecipeWriteForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

    @GetMapping("write")
    public String recipeWriteForm(Model model) {
        model.addAttribute("recipeWriteForm", new RecipeWriteForm());
        model.addAttribute("foodTypes", List.of(FoodType.values()));
        model.addAttribute("situationTypes", List.of(SituationType.values()));
        return "recipe/write";
    }

    @PostMapping("write")
    public String recipeWrite(@Validated @ModelAttribute RecipeWriteForm form, BindingResult bindingResult) {

        return "redirect:/";
    }
}
