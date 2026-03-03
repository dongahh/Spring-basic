package hello.core.Order;

import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;

public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order creadOrder(Long memberId, String itemName, int itmePrice) {
        Member memberA = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(memberA, itmePrice);

        // public Order(int discountPrice, int itemPrice, String itemName, Long memberId)
        return new Order(discount,itmePrice,itemName,memberId);
    }
}
