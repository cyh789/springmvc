package hello.springmvc.order;

import hello.springmvc.AutoAppConfig;
import hello.springmvc.discount.FixDiscountPolicy;
import hello.springmvc.discount.RateDiscountPolicy;
import hello.springmvc.member.Grade;
import hello.springmvc.member.Member;
import hello.springmvc.member.MemberService;
import hello.springmvc.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class OrderServiceImplTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void init() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        memberService = applicationContext.getBean(MemberService.class);
        orderService = applicationContext.getBean(OrderService.class);
    }

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void createOrder2() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberRepository.save(member);

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 30000);

        OrderServiceImpl orderService2 = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order2 = orderService2.createOrder(1L, "itemA", 30000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(3000);
        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(1000);
    }


}