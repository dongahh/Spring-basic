package hello.core.discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;

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
