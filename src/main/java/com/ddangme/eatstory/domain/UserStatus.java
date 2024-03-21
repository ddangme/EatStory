package com.ddangme.eatstory.domain;

import lombok.Getter;

@Getter
public enum UserStatus {
    NORMAL, // 정상
    WITHDRAWN, // 탈퇴
    SUSPENDED; // 정지

}
