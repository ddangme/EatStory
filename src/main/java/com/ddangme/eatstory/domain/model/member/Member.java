package com.ddangme.eatstory.domain.model.member;

import com.ddangme.eatstory.domain.model.recipe.Recipe;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_id")
    private Long id;

    private String loginId;

    private String password;

    private String nickname;

    private String phoneNumber;

    private LocalDate birthDay;

    private String email;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    private String profileImage;

    private String profileSentence;

    @CreatedDate
    private LocalDateTime joinDay;

    private int mileage;

    @Builder
    public Member(String loginId, String password, String nickname, String email) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    @OneToMany(mappedBy = "member")
    private List<Recipe> recipes = new ArrayList<>();
}
