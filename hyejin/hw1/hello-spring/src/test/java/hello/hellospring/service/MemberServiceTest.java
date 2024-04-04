package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository ;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() { //테스트코드에선 한글로도 가능
        //given : 이게 주어졌을 때
        Member member = new Member();
        member.setName("hello");

        //when : 이러한 상황에서
        Long saveId = memberService.join(member);
        //then : 이게 나와야 해
        Member findMember = memberService.findOne(saveId).get();
    }

    @Test
    public void 중복_회원_예외() {
            //Given
            Member member1 = new Member();
            member1.setName("spring");

            Member member2 = new Member();
            member2.setName("spring");

            //When
            memberService.join(member1);
            try {
                memberService.join(member2);
                fail();
            } catch (IllegalStateException e) {
            }
            //Then

    }

    @Test
    void findOne() {
    }
}