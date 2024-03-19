package com.ddangme.eatstory.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinRequest {

    @NotEmpty(message = "아이디를 입력해주세요.")
    @Size(min = 4, max = 20, message = "아이디를 4자에서 20자 사이로 입력해주세요.")
    private String userId;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    @Size(min = 4, max = 20, message = "비밀번호를 4자에서 20자 사이로 입력해주세요.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "숫자, 알파벳, 특수문자 조합으로 입력해주세요.")
    private String userPassword;

    @NotEmpty(message = "비밀번호 확인을 입력해주세요.")
    @Size(min = 4, max = 20, message = "비밀번호 확인을 4자에서 20자 사이로 입력해주세요.")
    private String userPasswordCheck;


}
