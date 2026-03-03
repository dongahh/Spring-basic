package hello.core.Order;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();

       // Long memberId = 1L;
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.creadOrder(member.getId(),"itemA", 10000 );

        System.out.println("order : " + order.toString());

    }
}
