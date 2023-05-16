package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class SingletonServiceTest {

//    @Test
//    @DisplayName("싱글톤의 문제점")
//    void statefulSingleton(){
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
//        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
//        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);
//
//        statefulService1.order("memberA", 10000);
//        statefulService2.order("memberB", 20000);
//
//        //memberA에서의 가격은 10000이 나와야 하지만 20000이 나옴. -> 이것이 싱글톤의 문제점
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
//
//    }
    @Test
    @DisplayName("싱글톤의 문제점 해결")
    void statefulSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        int memberAprice = statefulService1.order("memberA", 10000);
        int memberBprice = statefulService2.order("memberB", 20000);

        //변수를 공유하지않으면 문제가 해결
        Assertions.assertThat(memberAprice).isEqualTo(10000);

    }



    @Configuration
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}