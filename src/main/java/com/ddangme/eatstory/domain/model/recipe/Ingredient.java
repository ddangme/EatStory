package com.ddangme.eatstory.domain.model.recipe;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ingredient_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private String name;
    private String amount;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Ingredient parent;

    @OneToMany(mappedBy = "parent")
    private List<Ingredient> child = new ArrayList<>();

    public void addChildIngredient(Ingredient child) {
        this.child.add(child);
        child.setParent(this);
    }

    private void setParent(Ingredient parent) {
        this.parent = parent;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
        recipe.getIngredients().add(this);
    }


}
