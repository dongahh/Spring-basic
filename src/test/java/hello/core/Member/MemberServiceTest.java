package hello.core.Member;

import hello.core.Order.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

     MemberService memberService;

     @BeforeEach
     public void beforeEach(){
         AppConfig appConfig = new AppConfig();
         memberService = appConfig.memberService();
     }

     @Test
    void join(){
         //Given
         Member memberA = new Member(1L, "memberA", Grade.VIP);

         //When
         memberService.join(memberA);
         Member findmember = memberService.findMember(memberA.getId());

         //Then(검증)
         Assertions.assertEquals(memberA,findmember);




     }

}
