package hello.core.Order;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
       // AppConfig appConfig = new AppConfig();
       // OrderService orderService = appConfig.orderService();
       // MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        // Long memberId = 1L;
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.creadOrder(member.getId(),"itemA", 10000 );

        System.out.println("order : " + order.toString());

    }
}
