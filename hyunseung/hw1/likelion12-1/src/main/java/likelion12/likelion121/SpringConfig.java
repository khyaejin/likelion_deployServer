package likelion12.likelion121;

import jakarta.persistence.EntityManager;
import likelion12.likelion121.repository.*;
import likelion12.likelion121.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //Jdbc
//    private final DataSource dataSource;
//    // JPA
//    private final EntityManager em;
//
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
//
//        // 순수 Jdbc
////        return new JdbcMemberRepository(dataSource);
//
//        // Jdbc Template
////        return new JdbcTemplateMemberRepository(dataSource);
//
//        //JPA
//        return new JpaMemberRepository(em);
//    }
}
