package com.ddangme.eatstory.controller.user;

import com.ddangme.eatstory.dto.UserDto;
import com.ddangme.eatstory.dto.request.UserJoinRequest;
import com.ddangme.eatstory.dto.request.UserLoginRequest;
import com.ddangme.eatstory.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userLoginRequest", new UserLoginRequest());
        return "user/login";
    }


    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("userJoinRequest", new UserJoinRequest());

        return "user/join";
    }

    @PostMapping("/join")
    public String join(@Valid @ModelAttribute UserJoinRequest userJoinRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors() || joinValidateFail(userJoinRequest, bindingResult)) {
                log.error(bindingResult.toString());
            return "user/join";
        }
        userService.join(userJoinRequest);

        return "redirect:/login";
    }

    private boolean joinValidateFail(UserJoinRequest request, BindingResult bindingResult) {
        if (userService.existUserId(request.getUserId())) {
            bindingResult.addError(new FieldError("userJoinRequest", "userId", request.getUserId(), false, null, null, "이미 존재하는 아이디입니다."));

            return true;
        }
        if (!request.getUserPassword().equals(request.getUserPasswordCheck())) {
            bindingResult.addError(new FieldError("userJoinRequest", "userPasswordCheck", request.getUserPasswordCheck(), false, null, null, "비밀번호가 일치하지 않습니다."));

            return true;
        }

        return false;
    }

}
