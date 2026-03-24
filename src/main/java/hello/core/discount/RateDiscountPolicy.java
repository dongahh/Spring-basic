package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercnet = 10;
    @Override
    public int discount(Member member, int prince) {
        if(member.getGrade()== Grade.VIP){
            return prince * discountPercnet / 100;
        }else{
            return 0;
        }

    }
}
