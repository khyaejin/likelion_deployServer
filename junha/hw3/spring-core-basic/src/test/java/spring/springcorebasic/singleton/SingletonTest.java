package spring.springcorebasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.springcorebasic.AppConfig;
import spring.springcorebasic.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	public void singletonServiceTest(){
		// new SingletonService(); => 객체 생성을 막아두었기 (private) 때문에 생성 X

		// 2번 접근
		SingletonService instance1 = SingletonService.getInstance();
		SingletonService instance2 = SingletonService.getInstance();


		// static 객체에 접근하기 때문에 레퍼런스 값이 같다.
		System.out.println("instance1 = " + instance1);  // instance1 = spring.springcorebasic.singleton.SingletonService@54e041a4
		System.out.println("instance2 = " + instance2);  // instance2 = spring.springcorebasic.singleton.SingletonService@54e041a4

		Assertions.assertThat(instance1).isSameAs(instance2);

		instance1.logic();
	}

	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void springContainer(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);

		// 참조값이 같다.
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);

		Assertions.assertThat(memberService1).isSameAs(memberService2);

	}
}
