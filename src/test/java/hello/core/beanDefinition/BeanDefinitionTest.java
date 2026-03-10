package hello.core.beanDefinition;

import hello.core.Order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    /*
    스프링 빈은 beanDefinition 으로 스프링빈 메타정보를 추상화 한다.
    빈 등록 방식은 1. 직접등록방식 2. 팩토리등록방식이 있다.
     */
    @Test
    @DisplayName("빈 설정 메타정보")
    void findBeanDefinitionInfo(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = " + beanDefinitionName
                        + " beanDefinition = " + beanDefinition);
            }

        }
    }
}
