package spring.springcorebasic.scan;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.springcorebasic.member.MemberService;

class AutoAppConfigTest {

	// Component Scan Test
	@Test
	void basicScan(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		MemberService memberService = ac.getBean(MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}

}
