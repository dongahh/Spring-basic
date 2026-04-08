package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

    @Test
    public void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBea1 = ac.getBean(PrototypeBean.class);
        prototypeBea1.add();

        PrototypeBean prototypeBea2 = ac.getBean(PrototypeBean.class);
        prototypeBea2.add();
        Assertions.assertThat(prototypeBea1.getCount()).isSameAs(prototypeBea2.getCount()).isSameAs(1);


    }

    @Test
    public void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean singletonBean1 = ac.getBean(ClientBean.class);
        int count1 = singletonBean1.logic();

        ClientBean singletonBean2 = ac.getBean(ClientBean.class);
        int count2 = singletonBean2.logic();

        Assertions.assertThat(count1).isNotSameAs(count2);


    }

    @Scope("singleton") //생략가능
    static class ClientBean{
        private final PrototypeBean prototypeBean;

        public ClientBean (PrototypeBean prototypeBean){
            this.prototypeBean = prototypeBean;
        }

        public int  logic(){

            prototypeBean.add();
            return prototypeBean.getCount();
        }

    }

    @Scope("prototype")
    static class PrototypeBean {

        private int count = 0;

        public void add() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("prototype.init");
        }

        @PreDestroy
        public void distory() {
            System.out.println("prototype.distory");

        }
    }

}
