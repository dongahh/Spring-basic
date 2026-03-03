package hello.core.Order;

import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.FixDiscountPolicy;

//어플리캐이션 전체를 설정하고 관리하는 파일
public class AppConfig {

    /*AppConfig에서 하는 일은 MemberService 메서드를 통해서
    * MemberServiceImpl생성자를 실행시키고 구현체MemoryMemberRepository 를 대신해서 만들어줌.
    * 생성자 주입 방식의 DI구조!
    *
    * >> memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
    */
    public MemberService memberService(){

        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
