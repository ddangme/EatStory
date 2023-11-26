package com.ddangme.eatstory.web.form.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
public class MemberJoinForm {
    @NotBlank
    private String loginId;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    @NotBlank
    @Size(min = 10, max = 11)
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    @NotBlank
    private String email;
}
