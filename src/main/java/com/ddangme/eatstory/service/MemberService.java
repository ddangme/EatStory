package com.ddangme.eatstory.service;

import com.ddangme.eatstory.domain.model.member.Member;
import com.ddangme.eatstory.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        memberRepository.join(member);
        return member.getId();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    public boolean isNotLoginIdAvailable(String loginId) {
        return !memberRepository.findMemberByLoginId(loginId).isEmpty();
    }

    public boolean invalidRegex(String password) {
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return !matcher.find();
    }

    public boolean invalidPassword(String password, String passwordCheck) {
        return !password.equals(passwordCheck);
    }

    public boolean isNotEmailAvailable(String email) {
        return !memberRepository.findMemberByEmail(email).isEmpty();
    }




}
