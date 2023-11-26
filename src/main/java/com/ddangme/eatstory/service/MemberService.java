package com.ddangme.eatstory.service;

import com.ddangme.eatstory.domain.model.member.Member;
import com.ddangme.eatstory.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
