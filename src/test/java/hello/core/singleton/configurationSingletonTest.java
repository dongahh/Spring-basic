package hello.core.singleton;

import hello.core.Member.MemberRepository;
import hello.core.Member.MemberServiceImpl;
import hello.core.Order.AppConfig;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class configurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberServiceImpl1 = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl  orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberServiceImpl1.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository : " + memberRepository1);
        System.out.println("orderService -> memberRepository : " + memberRepository2);
        System.out.println("memberRepository : " + memberRepository);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println(bean.getClass());

        /*
        AppConfig.class를 출력하면 AppConfig@CGLIB 로 출력이 되는데.
        이는 스트링에서 AppConfig.class 를 상속받은 새로운 AppConfig@CGLIB 를 만들고 그것을 스프링 빈으로 등록된다.
        AppConfig@CGLIB 는 싱글톤으로 보장해 이미 생성된 객체를 제외한 새로운 객체만을 컨테이너에 등록한다.
        @Bean이 붙은 메서드마다 이미 스프링 빈이 존재하면 존재하는 빈을 반환 하도록 동적으로 만들어짐.

        *** AppConfig.class에서 @Configuration 을 지우면. 싱글톤을 보장하지 않는다.
        이는 즉 스프링에서 AppConfig 를 상속받는 AppConfig@CGLIB 를 새로 만들지 않는다.
         */
    }
}
