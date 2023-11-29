package com.ddangme.eatstory.web.controller;

import com.ddangme.eatstory.domain.model.member.Member;
import com.ddangme.eatstory.service.MemberService;
import com.ddangme.eatstory.web.form.member.MemberJoinForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("memberJoinForm", new MemberJoinForm());
        return "members/join";
    }

    @PostMapping("/join")
    public String join(@Validated @ModelAttribute MemberJoinForm joinForm, BindingResult bindingResult) {
        validateLoginId(joinForm.getLoginId(), bindingResult);
        validatePassword(joinForm.getPassword(), joinForm.getPasswordCheck(), bindingResult);
        validateEmail(joinForm.getEmail(), bindingResult);

        if (bindingResult.hasErrors()) {
            log.error("join errors: {}", bindingResult);
            return "members/join";
        }

        Member member = Member.builder()
                .loginId(joinForm.getLoginId())
                .password(joinForm.getPassword())
                .nickname(joinForm.getNickname())
                .email(joinForm.getEmail())
                .build();

        memberService.join(member);

        return "redirect:/";
    }



    private void validateLoginId(String loginId, BindingResult bindingResult) {
        if (memberService.isNotLoginIdAvailable(loginId)) {
            bindingResult.rejectValue("loginId", "Duplicate.memberJoinForm.loginId");
        }
    }

    private void validatePassword(String password, String passwordCheck, BindingResult bindingResult) {
        if (password != null && passwordCheck != null) {
            if (memberService.invalidPassword(password, passwordCheck)) {
                bindingResult.rejectValue("password", "Validate.memberJoinForm.password");
            }
            if (memberService.invalidRegex(password)) {
                bindingResult.rejectValue("password", "Regex.memberJoinForm.password");
            }
        }
    }

    private void validateEmail(String email, BindingResult bindingResult) {
        if (memberService.isNotEmailAvailable(email)) {
            bindingResult.rejectValue("email", "Duplicate.memberJoinForm.email");
        }
    }
}
