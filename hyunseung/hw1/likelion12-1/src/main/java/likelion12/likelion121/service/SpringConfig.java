package likelion12.likelion121.service;

import likelion12.likelion121.repository.MemberRepository;
import likelion12.likelion121.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
}
