package com.ddangme.eatstory.dto.response;

import com.ddangme.eatstory.domain.UserStatus;
import com.ddangme.eatstory.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinResponse {

    private Long id;
    private String userId;
    private UserStatus userStatus;

    public static UserJoinResponse fromUserDto(UserDto dto) {
        return new UserJoinResponse(
                dto.getId(),
                dto.getUserId(),
                dto.getUserStatus()
        );
    }
}
