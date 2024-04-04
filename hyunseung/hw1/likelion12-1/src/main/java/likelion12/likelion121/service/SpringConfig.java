package likelion12.likelion121.service;

import likelion12.likelion121.repository.JdbcMemberRepository;
import likelion12.likelion121.repository.MemberRepository;
import likelion12.likelion121.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
}
