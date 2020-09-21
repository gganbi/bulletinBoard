package com.study.bulletin.bulletinBoard.service;

import com.study.bulletin.bulletinBoard.domain.Member;
import com.study.bulletin.bulletinBoard.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testet() throws Exception {

//Given
        Member member = new Member();
        member.setName("kimmm");
//When
        Long saveId = memberService.join(member);
        assertNotNull(memberRepository.findById(saveId).orElse(null));
//Then
      //  fail("예외가 발생해야 한다.");
     //   assertEquals(member, memberRepository.findById(saveId).orElse(null));

    }

  //  @Test
    @Test(expected = IllegalStateException.class)
    @Rollback(false)
    public void test2() throws Exception {

//Given
        Member member3 = new Member();
        member3.setName("testt");
        Member member4 = new Member();
        member4.setName("testt");
//When
  //      assertNotNull(memberRepository.findById(memberService.join(member3)).orElse(null));
   //     assertNotNull(memberRepository.findById(memberService.join(member4)).orElse(null));
      //  memberService.join(member1);
       // memberService.join(member2); //예외가 발생해야 한다.
        assertEquals(memberRepository.findById(memberService.join(member3)).orElse(null),
                memberRepository.findById(memberService.join(member4)).orElse(null));
        fail("예외가 발생해야 한다.");
    }



}