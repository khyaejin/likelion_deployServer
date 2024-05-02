package spring.springcorebasic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import spring.springcorebasic.AppConfig;

public class SingletonTest {

	@Test
	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	void pureContainer(){
		AppConfig appConfig = new AppConfig();

		// 첫 번째 조회: 호출할 때 마다 객체를 생성
		MemberService memberService1 = appConfig.memberService();

		// 두 번째 조회: 호출할 때 마다 객체를 생성
		MemberService memberService2 = appConfig.memberService();


		// 객체의 레퍼런스 값이 다름
		System.out.println("memberService1 = " + memberService1); // spring.springcorebasic.member.MemberServiceImpl@4e0ae11f
		System.out.println("memberService2 = " + memberService2); // spring.springcorebasic.member.MemberServiceImpl@6c7a164b

		Assertions.assertThat(memberService1).isNotSameAs(memberService2);

	}
}
