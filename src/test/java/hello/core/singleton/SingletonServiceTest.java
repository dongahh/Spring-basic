package hello.core.singleton;

import hello.core.Member.MemberService;
import hello.core.Order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonServiceTest {

    @Test
    @DisplayName("퓨어 컨테이너 테스트")
    void pureContaner(){
        AppConfig appConfig = new AppConfig();
        //호출할때마다 다른 객체를 생성한다.
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 : " + memberService1);
        System.out.println("memberService2 : " + memberService2);
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);


    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {

        //new SingletonService(); // 생성자 생성 불가
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 : " + singletonService1);
        System.out.println("singletonService2 : " + singletonService2);
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
        //isSameAs() : ==와 동일한 함수로 메모리도 동일한지 확인.
        //isEqualTo() : 내용이 동일한지 확인.


    }

    @Test
    @DisplayName("스프링 컨테이너 테스트")
    void SpringContaner(){
        //AppConfig appConfig = new AppConfig();
        //스프링은 기본적으로 appConfig 를 활용할때 Singleton을 기반으로 객체를 사용한다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //호출할때마다 다른 객체를 생성한다.
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 : " + memberService1);
        System.out.println("memberService2 : " + memberService2);
        Assertions.assertThat(memberService1).isSameAs(memberService2);


    }
}
