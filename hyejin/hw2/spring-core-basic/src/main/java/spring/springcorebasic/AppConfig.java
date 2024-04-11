package spring.springcorebasic;

import spring.springcorebasic.discount.DiscountPolicy;
import spring.springcorebasic.discount.FixDiscountPolicy;
import spring.springcorebasic.discount.RateDiscountPolicy;
import spring.springcorebasic.member.MemberRepository;
import spring.springcorebasic.member.MemberService;
import spring.springcorebasic.member.MemberServiceImpl;
import spring.springcorebasic.member.MemoryMemberRepository;
import spring.springcorebasic.order.OrderService;
import spring.springcorebasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl( memberRepository());
    }

    public OrderService orderSercice(){
        return new OrderServiceImpl( memberRepository(), new FixDiscountPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy(); //구체만 변경해주면 됨(DIP 위반 x)
    }
}
