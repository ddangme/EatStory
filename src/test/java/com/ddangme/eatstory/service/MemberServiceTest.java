package com.ddangme.eatstory.service;

import com.ddangme.eatstory.domain.model.member.Member;
import com.ddangme.eatstory.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        Member member = Member.builder()
                .email("test@test.com")
                .password("qwer1234!")
                .nickname("tester")
                .loginId("test123")
                .build();

        Long joinId = memberService.join(member);

        Member findMember = memberRepository.findById(joinId);
        assertThat(member).isEqualTo(findMember);
    }
}