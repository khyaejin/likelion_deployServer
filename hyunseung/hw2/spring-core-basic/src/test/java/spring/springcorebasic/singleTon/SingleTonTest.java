package spring.springcorebasic.singleTon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTonTest {
    @Test
    @DisplayName("SingleTon Pattern을 적용한 객체 사용")
    void SingleTonSerivceTest() {
        SingleTonService singleTonService1 = SingleTonService.getInstance();
        SingleTonService singleTonService2 = SingleTonService.getInstance();

        System.out.println("SingleTonService1: " + singleTonService1);
        System.out.println("SingleTonService2: " + singleTonService2);

        Assertions.assertThat(singleTonService1).isSameAs(singleTonService2);
    }
}
