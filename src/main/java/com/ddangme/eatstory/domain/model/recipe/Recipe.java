package com.ddangme.eatstory.domain.model.recipe;

import com.ddangme.eatstory.domain.model.UploadFile;
import com.ddangme.eatstory.domain.model.member.Member;
import com.ddangme.eatstory.domain.model.recipe.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "recipe_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private String describe;

    private String videoLink;

    private String cookTips;
    private Long hit;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private double score;

    @Embedded
    private Category category;

    @Embedded
    private UploadFile mainPhoto;

    @Enumerated(EnumType.STRING)
    private RecipeStatus recipeStatus;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe")
    private List<RecipeStep> recipeSteps = new ArrayList<>();

    @OneToMany(mappedBy = "recipe")
    private List<RecipeFinalImage> recipeFinalImages = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
        member.getRecipes().add(this);
    }
}
