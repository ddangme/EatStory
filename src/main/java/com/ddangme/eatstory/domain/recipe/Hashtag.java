package com.ddangme.eatstory.domain.recipe;

import com.ddangme.eatstory.domain.AuditingFields;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(indexes = {
        @Index(columnList = "name", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
public class Hashtag extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "hashtags")
    private Set<Recipe> recipes = new LinkedHashSet<>();
}
