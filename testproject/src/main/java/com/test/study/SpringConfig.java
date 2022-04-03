package com.test.study;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.study.aop.TimeTraceAop;
import com.test.study.repository.JdbcMemberRepository;
import com.test.study.repository.JdbcTemplateMemberRepository;
import com.test.study.repository.JpaMemberRepository;
import com.test.study.repository.MemberRepository;
import com.test.study.repository.MemoryMemberRepository;
import com.test.study.service.MemberService;

@Configuration
public class SpringConfig {

//	private DataSource dataSource;
//	@Autowired
//	public SpringConfig(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	private final MemberRepository memberRepository;
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
//	@Bean
//	public TimeTraceAop timeTraceAop() {
//		return new TimeTraceAop();
//	}
	
	/*
	 * @Bean public MemberRepository memberRepository() {
	 */
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepository(dataSource);
/*		return new JpaMemberRepository(em);
	}*/
	
}
