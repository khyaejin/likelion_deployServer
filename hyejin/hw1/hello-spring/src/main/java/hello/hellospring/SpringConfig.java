package hello.hellospring;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); //^+p 인자 타입 알 수 있는 단축기
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}