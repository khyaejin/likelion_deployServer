package spring.springcorebasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void SingletonSerivceTest() {
        //2번 접근
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("SingletonService1: " + singletonService1);
        System.out.println("SingletonService2: " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }
}