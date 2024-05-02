package spring.springcorebasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springcorebasic.discount.DiscountPolicy;
import spring.springcorebasic.discount.FixDiscountPolicy;
import spring.springcorebasic.discount.RateDiscountPolicy;
import spring.springcorebasic.member.MemberRepository;
import spring.springcorebasic.member.MemberService;
import spring.springcorebasic.member.MemberServiceImpl;
import spring.springcorebasic.member.MemoryMemberRepository;
import spring.springcorebasic.order.OrderService;
import spring.springcorebasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){ //Bean 이름은 다 달라야함
        return new MemberServiceImpl( memberRepository());
    }
    @Bean
    public OrderService orderSercice(){
        return new OrderServiceImpl( memberRepository(), new FixDiscountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy(); //구체만 변경해주면 됨(DIP 위반 x)
    }
}
