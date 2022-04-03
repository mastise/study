package com.test.study.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.test.study.domain.Member;
import com.test.study.repository.MemberRepository;
import com.test.study.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

	@Autowired MemberService memberService;// = new MemberService();
	@Autowired MemberRepository memberRepository; // = new MemoryMemberRepository();
	
	
	@Test
	void ȸ������() {
		//given
		Member member = new Member();
		member.setName("spring");
	
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
		
	}
	@Test
	void �ߺ�_ȸ��_����() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�.");

	}
}
