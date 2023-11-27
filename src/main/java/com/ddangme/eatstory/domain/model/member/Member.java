package com.ddangme.eatstory.domain.model.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    private String password;

    private String nickname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    private String email;

    @Column(name = "member_type")
    @Embedded
    private MemberType memberType;

    @Column(name = "member_status")
    @Embedded
    private MemberStatus memberStatus;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "profileSentence")
    private String profileSentence;

    @Column(name = "join_day")
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

}
