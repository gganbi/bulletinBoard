package com.study.bulletin.bulletinBoard.service;

import com.study.bulletin.bulletinBoard.domain.Member;
import com.study.bulletin.bulletinBoard.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testet() throws Exception {

//Given
        Member member = new Member();
        member.setName("kim");
//When
        Long saveId = memberService.join(member);
//Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

}