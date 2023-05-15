package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @param member 주문하는 멤버
     * @param price 물건 가격
     * @return 할인할 가격
     */
    int discount(Member member, int price);
}
