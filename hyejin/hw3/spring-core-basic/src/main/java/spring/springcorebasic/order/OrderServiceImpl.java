package spring.springcorebasic.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.springcorebasic.discount.DiscountPolicy;
import spring.springcorebasic.discount.FixDiscountPolicy;
import spring.springcorebasic.discount.RateDiscountPolicy;
import spring.springcorebasic.member.Member;
import spring.springcorebasic.member.MemberRepository;
import spring.springcorebasic.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

    // 회원의 등급을 확인하기 위함 => 할인정책 적용을 위해

    private final MemberRepository memberRepository ;
    private DiscountPolicy discountPolicy;
    // DIP 위반 -> 구체에 의존하지 않고 추상에만 의존하도록 변경
    // 그렇다면 discountPolicy의 초기화는 어떻게? -> 누군가 DiscountPolicy의 구현 객체를 생성해줘야 함
    // 단일 책임의 원칙.

    // 생성자를 사용하여 의존관계 주입(생성자 주입)
    // @Autowired : 생성자가 하나만 있으면 @Autowired 지울 수 있음
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 사용자의 등급을 통해 할인정책을 달리 하기 위함
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문을 생성하여 반환

    }
}