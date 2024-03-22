package com.ddangme.eatstory.controller.user;

import com.ddangme.eatstory.dto.request.UserJoinRequest;
import com.ddangme.eatstory.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("request", new UserJoinRequest());
        return "user/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@Valid @ModelAttribute("request") UserJoinRequest request, BindingResult bindingResult) {
        if (!request.getPassword().equals(request.getPasswordCheck())) {
            bindingResult.addError(new FieldError("request", "passwordCheck", "비밀번호가 일치하지 않습니다."));
        }

        if (userService.existUserId(request.getUserId())) {
            bindingResult.addError(new FieldError("request", "userId", "존재하는 아이디입니다."));
        }

        if (bindingResult.hasErrors()) {
            log.error(bindingResult.toString());
            return "user/sign-up";
        }

        userService.signUp(request);

        return "main";
    }
}
