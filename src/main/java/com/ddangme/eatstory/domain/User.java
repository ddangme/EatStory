package com.ddangme.eatstory.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString(callSuper = true)
@Table
@Entity(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String img;

    private LocalDateTime deletedAt;

    public static User join(String userId, String password) {
        return User.builder()
                .userId(userId)
                .password(password)
                .nickname(userId)
                .userRole(UserRole.USER)
                .userStatus(UserStatus.NORMAL)
                .img(null)
                .build();
    }

}
