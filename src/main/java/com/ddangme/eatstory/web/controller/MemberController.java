package com.ddangme.eatstory.web.controller;

import com.ddangme.eatstory.domain.model.member.Member;
import com.ddangme.eatstory.service.MemberService;
import com.ddangme.eatstory.web.form.member.MemberJoinForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("memberJoinForm", new MemberJoinForm());
        return "members/memberJoinForm";
    }

    @PostMapping("/join")
    public String join(@Validated @ModelAttribute MemberJoinForm joinForm, BindingResult bindingResult) {

        if (memberService.isNotLoginIdAvailable(joinForm.getLoginId())) {
            bindingResult.rejectValue("loginId", "duplicate.memberJoinForm.loginId");
        }

        if (joinForm.getPassword() != null && joinForm.getPasswordCheck() != null) {
            if (memberService.invalidPassword(joinForm.getPassword(), joinForm.getPasswordCheck())) {
                bindingResult.rejectValue("password", "validate.memberJoinForm.password");
            }
            if (memberService.invalidRegex(joinForm.getPassword(), joinForm.getPasswordCheck())) {
                bindingResult.rejectValue("password", "regex.memberJoinForm.password");
            }
        }

        if (memberService.isNotEmailAvailable(joinForm.getEmail())) {
            bindingResult.rejectValue("email", "duplicate.memberJoinForm.email");
        }

        if (bindingResult.hasErrors()) {
            log.error("join errors: {}", bindingResult);
            return "members/memberJoinForm";
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
}
