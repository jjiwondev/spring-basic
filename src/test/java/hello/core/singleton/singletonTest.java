package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class singletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회: 호출할 때 마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        //이 둘은 다른 객체임. 즉, 호출할때 마다 매번 다른 객체가 생성되는 것이 문제점임.
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        //이 둘은 같은 객체임. static영역의 instance를 보내주었기 때문.
        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출할 때 마다 객체 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        //2. 조회: 호출할 때 마다 객체 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //이 둘은 같은 객체임. 스프링 컨테이너에서 싱글톤을 지원하기 때문에!
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
