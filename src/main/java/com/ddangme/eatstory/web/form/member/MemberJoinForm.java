package com.ddangme.eatstory.web.form.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberJoinForm {
    @NotBlank
    private String loginId;

    private String password;

    @NotBlank
    private String passwordCheck;

    @NotBlank
    private String nickname;

    @NotBlank
    @Email
    private String email;
}
