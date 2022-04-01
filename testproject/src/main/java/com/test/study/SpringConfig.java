package com.test.study;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.study.repository.JdbcMemberRepository;
import com.test.study.repository.JdbcTemplateMemberRepository;
import com.test.study.repository.MemberRepository;
import com.test.study.repository.MemoryMemberRepository;
import com.test.study.service.MemberService;

@Configuration
public class SpringConfig {

	private DataSource dataSource;
	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		return new JdbcTemplateMemberRepository(dataSource);
	}
	
}
