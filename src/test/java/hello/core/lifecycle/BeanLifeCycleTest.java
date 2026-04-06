package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient cli = ac.getBean(NetworkClient.class);
        ac.close(); // 스프링 컨데이너를 종료시킴 ( ConfigurableApplicationContext 에서 사용)
    }


    @Configuration
    static class LifeCycleConfig{

        /* 1.
        @Bean(initMethod = "init", destroyMethod = "close")
        //@Bean에 destroyMethod 추론의 성질이 있어서 cloae나 chutdown 메서드를 자동으로 호출함.
        //이를 막으려면 destroyMethod = "" 빈 값으로 지정해 주면 된다.
        public NetworkClient networkClient(){

            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;

        }
         */

        //2.
        @Bean
        //소스에서 에노테이션 등록
        public NetworkClient networkClient(){

            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;

        }
    }
}
