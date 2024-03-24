package com.ddangme.eatstory.domain.recipe;

import com.ddangme.eatstory.domain.recipe.constants.*;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Embeddable
public class RecipeCategory {

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Situation situation;

    @Enumerated(EnumType.STRING)
    private Method method;

    @Enumerated(EnumType.STRING)
    private Ingredient ingredient;

    @Enumerated(EnumType.STRING)
    private People people;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Enumerated(EnumType.STRING)
    private Time time;
}
