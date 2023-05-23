package hello.springmvc.discount;

import hello.springmvc.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}