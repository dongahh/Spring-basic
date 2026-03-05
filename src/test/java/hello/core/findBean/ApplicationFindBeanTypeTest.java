package hello.core.findBean;

import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.Order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationFindBeanTypeTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Bean이름으로 조회")
    void findBeanByName(){
        MemberService memberService = annotationConfigApplicationContext.getBean("memberService", MemberServiceImpl.class);// 빈 이름과 타입으로 찾기
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Bean 타입으로 조회")
    void findBeanByType(){
        MemberServiceImpl bean = annotationConfigApplicationContext.getBean(MemberServiceImpl.class);

        Assertions.assertThat(bean).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("Bean 조회 오류")
    void findBeanByNameX(){
        //MemberService memberService =
                //annotationConfigApplicationContext.getBean("xxxxxx", MemberService.class);
        //Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
            () ->   annotationConfigApplicationContext.getBean("xxxxxx", MemberService.class)
        );
    }


}
