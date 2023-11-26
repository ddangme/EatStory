package com.ddangme.eatstory.domain.repository;

import com.ddangme.eatstory.domain.model.member.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void join(Member member) {
        em.persist(member);
    }

}