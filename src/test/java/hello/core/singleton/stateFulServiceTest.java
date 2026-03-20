package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class stateFulServiceTest {

    @Test
    @DisplayName("싱글톤 생성의 문제")
    void stateFulServiceSingletonTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(testConfig.class);
        stateFulService stateFulSerice1 = ac.getBean("stateFulService", stateFulService.class);
        stateFulService stateFulSerice2 = ac.getBean("stateFulService", stateFulService.class);

        stateFulSerice1.order("name1" , 1000);
        stateFulSerice2.order("name2" , 2000);

        System.out.println("stateFulSerice1 : " + stateFulSerice1.getPrce());
        System.out.println("stateFulSerice2 : " + stateFulSerice2.getPrce());

        Assertions.assertThat(stateFulSerice1.getPrce()).isEqualTo(2000);
    }

    @Test
    @DisplayName("싱글톤 생성의 문제 해결")
    void stateFulServiceSingletonTest2(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(testConfig.class);
        stateFulService stateFulSerice1 = ac.getBean("stateFulService", stateFulService.class);
        stateFulService stateFulSerice2 = ac.getBean("stateFulService", stateFulService.class);

        int priceOfName1 = stateFulSerice1.order2("name1" , 1000);
        int priceOfName2 = stateFulSerice2.order2("name2" , 2000);

        System.out.println("stateFulSerice1 : " + priceOfName1);
        System.out.println("stateFulSerice2 : " + priceOfName2);

        Assertions.assertThat(priceOfName1).isEqualTo(1000);
    }
}

class testConfig{
    @Bean
    public stateFulService stateFulService(){
        return new stateFulService();
    }
}
