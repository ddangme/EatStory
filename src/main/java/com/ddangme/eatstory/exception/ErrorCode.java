package com.ddangme.eatstory.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "User Id is duplicated."),
    MISMATCH_PASSWORD(HttpStatus.BAD_REQUEST, "Password and Password Check do not match."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "user not found."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "password is invalid"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Token is invalid"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
