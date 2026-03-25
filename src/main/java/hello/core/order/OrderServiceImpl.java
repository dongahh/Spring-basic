package hello.core.order;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.discount.DiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

   /*
    @Autowired private  MemberRepository memberRepository;
    @Autowired private  DiscountPolicy discountPolicy;
    >> 필드주입 권장하지는 않음 :: 스프링 부트 왜에선 테스트 사용 불가능
    */
    private  MemberRepository memberRepository;
    private  DiscountPolicy discountPolicy;


    /*
    수정자 주입(수정자 메서드를 사용하는 의존성 주입)
    생성자의 의존성주입이 먼저 일어나고 그 후 에 set/get 함수가 주입이 된다.
    이는 결국 set/get을 호출하려면 new 로해서 객체를 만들어야하기 때문에 생성자 함수가 먼저 호출이 될 수 밖에 없다.

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
        System.out.println("memberRepository : " + memberRepository);
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
        System.out.println("discountPolicy : " + discountPolicy);
    }
     */

    @Autowired
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

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
