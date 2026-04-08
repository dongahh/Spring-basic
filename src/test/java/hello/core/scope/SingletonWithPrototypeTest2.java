package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

public class SingletonWithPrototypeTest2 {

    /*
    프로토타입과 싱긅톤 타입을 동시에 사용하고 싶을때
    1. 프로토타입을 사용할때마다 스프링 컨테이너에 새로 요청하기.
    2. ObjectFatory, ObjectProvider 사용해주기 : 지정한 빈을 컨테이너에서 대신 찾아준는 DL(Dependency Lookup) 사용
    3. JSR-330 Provide 사용
     */
    @Test
    public void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean2.class, PrototypeBean.class);

        ClientBean2 ClientBean1 = ac.getBean(ClientBean2.class);
        int count1 = ClientBean1.logic();

        ClientBean2 ClientBean2 = ac.getBean(ClientBean2.class);
        int count2 = ClientBean2.logic();

        //Assertions.assertThat(count1).isNotSameAs(count2); //기본타입은 주소가 없기때문에 isSameAs 사용 안함
        Assertions.assertThat(count1).isEqualTo(count2);


    }

    static class ClientBean{

        @Autowired
        private ApplicationContext ac;

        public ClientBean(ApplicationContext ac){
            this.ac = ac;
        }

        public int logic(){

            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
            prototypeBean.add();
            return prototypeBean.getCount();

        }

    }

    static class ClientBean2{

        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanObjectProvider;


        public int logic(){

            PrototypeBean prototypeBean = prototypeBeanObjectProvider.getObject();
            prototypeBean.add();
            return prototypeBean.getCount();

        }

    }
    static class ClientBean3{

        @Autowired
        private Provider<PrototypeBean> provider;

        public int logic(){

            PrototypeBean prototypeBean = provider.get();
            //provider.get()을 통해 항상 새로운 프로토타입빈이 생성되는 것을 확인할 수 있다.
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
            System.out.println("prototype.init" + this);
        }

        @PreDestroy
        public void distory() {
            System.out.println("prototype.distory");

        }
    }
}
