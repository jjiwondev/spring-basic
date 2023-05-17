package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        DiscountService discountService = ac.getBean(DiscountService.class);
        int fixedDiscountPrice = discountService.getPrice(memberA, 20000,"fixDiscountPolicy");
        int ratedDiscountPrice = discountService.getPrice(memberA, 20000,"rateDiscountPolicy");
        Assertions.assertThat(fixedDiscountPrice).isEqualTo(1000);
        Assertions.assertThat(ratedDiscountPrice).isEqualTo(2000);

    }

    static class DiscountService{
        private final List<DiscountPolicy> policies;
        private final Map<String, DiscountPolicy> policiesMap;

        @Autowired

        public DiscountService(List<DiscountPolicy> policies, Map<String, DiscountPolicy> policiesMap) {
            this.policies = policies;
            this.policiesMap = policiesMap;
            System.out.println("policies = " + policies);
            System.out.println("policiesMap = " + policiesMap);
        }

        public int getPrice(Member memberA, int price, String discountName) {
            DiscountPolicy discountPolicy = policiesMap.get(discountName);
            int discountPrice = discountPolicy.discount(memberA, price);
            return discountPrice;
        }
    }
}
