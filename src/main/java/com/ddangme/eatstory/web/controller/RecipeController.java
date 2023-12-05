package com.ddangme.eatstory.web.controller;

import com.ddangme.eatstory.common.SessionConst;
import com.ddangme.eatstory.domain.model.UploadFile;
import com.ddangme.eatstory.domain.model.member.Member;
import com.ddangme.eatstory.domain.model.recipe.Recipe;
import com.ddangme.eatstory.domain.model.recipe.RecipeStatus;
import com.ddangme.eatstory.domain.model.recipe.category.*;
import com.ddangme.eatstory.service.MemberService;
import com.ddangme.eatstory.service.RecipeService;
import com.ddangme.eatstory.web.form.recipe.RecipeIngredientWriteForm;
import com.ddangme.eatstory.web.form.recipe.RecipeWriteForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private final RecipeService recipeService;
    private final MemberService memberService;

    @GetMapping("write")
    public String RecipeDetailWriteForm(Model model) {
        addCategory(model);
        model.addAttribute("recipeWriteForm", new RecipeWriteForm());
        return "recipe/write";
    }

    @PostMapping("write")
    public String recipeWrite(@ModelAttribute RecipeWriteForm form, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long loginId = (Long) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Member member = memberService.findById(loginId);
        Recipe recipe = parseToRecipe(form, member);

        recipeService.saveRecipeData(recipe);
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

    private Recipe parseToRecipe(RecipeWriteForm form, Member member) {
        Category category = Category.builder()
                .foodType(form.getFoodType())
                .situationType(form.getSituationType())
                .methodType(form.getMethodType())
                .ingredientType(form.getIngredientType())
                .foodSize(form.getFoodSize())
                .cookingTime(form.getCookingTime())
                .difficultyLevel(form.getDifficultyLevel())
                .build();

        Recipe recipe = Recipe.builder()
                .title(form.getTitle())
                .describe(form.getDescribe())
                .videoLink(form.getVideoLink())
                .cookTips(form.getCookTips())
                .category(category)
                .recipeStatus(RecipeStatus.NORMAL)
                .member(member)
                .build();

        return recipe;
    }
}
