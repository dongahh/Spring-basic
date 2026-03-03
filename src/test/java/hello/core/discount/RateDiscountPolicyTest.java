package hello.core.discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
//alt + enter 하구 ondmened 하면 static으로 생성됨.

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("TIP는 10% 할인이 적용되어야 한다.")
    void vipCheck(){
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        int ratePrice = discountPolicy.discount(member,10000);

        assertThat(ratePrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인은 적용되지 않는다.")
    void basicCheck(){
        Member member = new Member(2L,"memberBasic",Grade.BASIC);

        int ratePrice1 = discountPolicy.discount(member,10000);
        assertThat(ratePrice1).isEqualTo(0);
    }


}