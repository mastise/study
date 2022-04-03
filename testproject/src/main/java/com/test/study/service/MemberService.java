package com.test.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.study.domain.Member;
import com.test.study.repository.MemberRepository;

//@Service
@Transactional
public class MemberService {

	private final MemberRepository memberRepository;
	
	//@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	/**	
	 * ȸ������
	 */
	
	public Long join (Member member) {
		// ���� �̸� x
		validateDuplicateMember(member);	// �ߺ� ȸ�� ����
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
		.ifPresent(m->{
	throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
	});
	}
	
	/**
	 * ��ü ȸ�� ��ȸ
	 */
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}

