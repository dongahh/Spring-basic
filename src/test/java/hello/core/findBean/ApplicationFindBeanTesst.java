package hello.core.findBean;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationFindBeanTesst {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 Bean 출력")
    void findBean(){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = annotationConfigApplicationContext.getBean(beanDefinitionName);

            System.out.println("baen Name : " + beanDefinitionName + "/beanObject = " + bean);

        }
    }

    @Test
    @DisplayName("Application Bean 출력하기.ㄴ")
    void findApplicationBean(){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = annotationConfigApplicationContext.getBeanDefinition(beanDefinitionName);


            //BeanDefinition.ROLE_APPLICATION : 직접 등록한 어플리케이션 빈
            //BeanDefinition.ROLE_INFRASTRUCTURE :  스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE){
                Object bean = annotationConfigApplicationContext.getBean(beanDefinitionName);
                System.out.println("bean Name : " + beanDefinitionName + "beanObject :  " + bean);
            }


        }

    }



}
