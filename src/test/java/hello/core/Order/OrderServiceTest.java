package hello.core.Order;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }



    @Test
    void createOrder(){
        Member member = new Member(1L,"memberA" , Grade.VIP);
        memberService.join(member);

        Order order = orderService.creadOrder(member.getId(),"itemA" ,10000);

        Assertions.assertThat(order.getItemPrice()).isEqualTo(10000);
    }
}
