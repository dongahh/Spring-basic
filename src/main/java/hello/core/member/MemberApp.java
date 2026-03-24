package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService  = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
                                                                    //메서드명 , 반환타입정보

        Member member1 = new Member(1L, "member1", Grade.VIP); //ctrl + alt + v
        memberService.join(member1);
        Member member2 = memberService.findMember(member1.getId());

        System.out.println("member1  = "  + member1.getId());
        System.out.println("member2  = "  + member2.getId());
    }
}
