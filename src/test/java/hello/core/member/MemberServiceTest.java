package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//첫번째 para는 메소드 이름으로 등록, 두번째 para는 타입

    @BeforeEach
    public void beforeEach(){
//        AppConfig appConfig = new AppConfig();
//        memberService = appConfig.memberService();

    }

    @Test
    void join(){
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        Assertions.assertThat(member).isEqualTo(findmember);
    }
}
