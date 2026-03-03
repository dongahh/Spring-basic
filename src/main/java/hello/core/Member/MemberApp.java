package hello.core.Member;

import hello.core.Order.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService  = appConfig.memberService();

        Member member1 = new Member(1L, "member1", Grade.VIP); //ctrl + alt + v
        memberService.join(member1);
        Member member2 = memberService.findMember(member1.getId());

        System.out.println("member1  = "  + member1.getId());
        System.out.println("member2  = "  + member2.getId());
    }
}
