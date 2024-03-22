package com.ddangme.eatstory.dto;

import com.ddangme.eatstory.domain.user.User;
import com.ddangme.eatstory.domain.user.UserRole;
import com.ddangme.eatstory.domain.user.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String userId;
    private String password;
    private String nickname;
    private UserStatus userStatus;
    private UserRole userRole;
    private String img;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private LocalDateTime deletedAt;

    private UserDto(Long id, String userId, String password, String nickname) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
    }


    public static UserDto fromEntity(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getUserId(),
                entity.getPassword(),
                entity.getNickname(),
                entity.getUserStatus(),
                entity.getUserRole(),
                entity.getImg(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy(),
                entity.getDeletedAt()
        );
    }

    public static UserDto of(Long id, String userId, String password, String nickname) {
        return new UserDto(id, userId, password, nickname);
    }

}
