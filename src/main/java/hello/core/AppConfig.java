package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*AppConfig에서 하는 일은 MemberService 메서드를 통해서
    * MemberServiceImpl생성자를 실행시키고 구현체MemoryMemberRepository 를 대신해서 만들어줌.
    * 생성자 주입 방식의 DI구조!
    *
    * >> memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
    */

    /*
    * @Bean memberService() -> MemoryMemberRepository
    * @Bean orderService() -> MemoryMemberRepository
    *
    * */
    @Bean
    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }

    //리팩토링 (ctrl + alt + M)
    @Bean
    public  MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public  DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
        //return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
