package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.jspecify.annotations.NonNull;

//어플리캐이션 전체를 설정하고 관리하는 파일
public class AppConfig1 {

    /*AppConfig에서 하는 일은 MemberService 메서드를 통해서
    * MemberServiceImpl생성자를 실행시키고 구현체MemoryMemberRepository 를 대신해서 만들어줌.
    * 생성자 주입 방식의 DI구조!
    *
    * >> memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
    */
    public MemberService memberService(){

        return new MemberServiceImpl(MemberRepository());
    }

    //리팩토링 (ctrl + alt + M)
    private static @NonNull MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    private static DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
        //return new RateDiscountPolicy();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }
}
