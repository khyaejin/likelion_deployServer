package spring.springcorebasic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.springcorebasic.AppConfig;

public class SingleTonTest {
    AppConfig appConfig = new AppConfig();
    @Test
    @DisplayName("Spring이 없는 순수 DI Container")
    void pureContainer() {
        // 첫 번째 호출
        MemberService memberService1 = appConfig.memberService();
        // 두 번째 호출
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberSerivce1: " + memberService1);
        System.out.println("memberSerivce2: " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
