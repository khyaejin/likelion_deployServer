package hello.hellospring.config;
import javax.sql.DataSource;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
	private final DataSource dataSource;
	private final EntityManager em;
	public SpringConfig(DataSource dataSource, EntityManager em) {
		this.em = em;
		this.dataSource = dataSource;
	}
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	@Bean
	public MemberRepository memberRepository() {
		// return new MemoryMemberRepository();

		// return new JdbcMemberRepository(dataSource);

		// return new JdbcTemplateMemberRepository(dataSource);

		return new JpaMemberRepository(em);
	}
}
