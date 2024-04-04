package hello.hellospring;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired //생략가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    private DataSource dataSource;
//    private final EntityManager em;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository); //^+p 인자 타입 알 수 있는 단축기
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

    /**
     * 스프링의 DI(Dependence Injection)
     *
     * spring을 사용하는 이유. 다형성이 좋음(객체지향언어의 특성)
     * 기존코드는 그대로 두고
     * 이 코드들만 손봤는데 구현 클래스가 변경됨
     *
     * 개방-폐쇄 원칙(OCP, Open-Closed Principle)
     * 확장에는 열려있고, 수정, 변경에는 닫혀있다
     *
     */

    /**
     * JPA
     *
     *  JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해줌
     *  JPA를 사용하면 SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있음
     *  JPA를 사용하면 개발 생산성을 크게 높일 수 있음
     */


    /**
     * 스프링 데이터 JPA
     *
     * 인터페이스를 통한 기본적인 CRUD
     *  findByName(), findByEmail() 처럼 메서드 이름 만으로 조회 기능 제공
     * 페이징 기능 자동 제공
     *
     */
}