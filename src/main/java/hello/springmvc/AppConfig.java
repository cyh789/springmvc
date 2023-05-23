//package hello.springmvc;
//
//import hello.springmvc.discount.DiscountPolicy;
//import hello.springmvc.discount.FixDiscountPolicy;
//import hello.springmvc.discount.RateDiscountPolicy;
//import hello.springmvc.member.MemberRepository;
//import hello.springmvc.member.MemberService;
//import hello.springmvc.member.MemberServiceImpl;
//import hello.springmvc.member.MemoryMemberRepository;
//import hello.springmvc.order.OrderService;
//import hello.springmvc.order.OrderServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//
//    @Bean
//    public OrderService orderService() {
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    @Bean
//    public DiscountPolicy discountPolicy() {
//        //return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
//    }
//
//
//}
