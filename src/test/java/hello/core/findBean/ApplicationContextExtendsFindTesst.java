package hello.core.findBean;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTesst {
//1번 타입으로 조회하면 1번 타입을 상속받은 모든 빈을 조회한다.

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);





    @Test
    @DisplayName("부모 타입으로 조회 시, 둘 이상의 상속이 있으면 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> annotationConfigApplicationContext.getBean(DiscountPolicy.class));

    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 둘 이상의 상속이 있으면 중복 오류가 발생한다.")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> beansOfType = annotationConfigApplicationContext.getBeansOfType(DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 둘 이상의 상속이 있으면 중복 오류가 발생한다.")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = annotationConfigApplicationContext.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key);
        }
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 둘 이상의 상속이 있으면 Bean Name 으로 조회한다.")
    void findBeanByName(){
        RateDiscountPolicy bean = annotationConfigApplicationContext.getBean(RateDiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(RateDiscountPolicy.class);

    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 둘 이상의 상속이 있으면 하위 타입으로 조회.")
    void findBeanBySubType(){
        DiscountPolicy bean = annotationConfigApplicationContext.getBean("rateDiscountPolicy",DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(DiscountPolicy.class);

    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy FixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

}
