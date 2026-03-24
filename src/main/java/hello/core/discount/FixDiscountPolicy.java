package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;


public class FixDiscountPolicy implements DiscountPolicy {

    private int DiscountFixCount = 2000;

    @Override
    public int discount(Member member, int prince) {
        if(member.getGrade()==Grade.VIP){
            return DiscountFixCount;
        }

        return 0;
    }
}
