package hello.core.Autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(OptionConfig.class);
    }


    @Configuration
    static class OptionConfig{

        //member은 스프링에 자동으로 주입된 객체가 아님!!
        @Autowired(required = false)
        public void setNoBean1(Member member1){
            System.out.println("setNoBean1 : " + member1);
        }


        @Autowired(required = false)
        public void setNoBean2(@Nullable Member member2){
            System.out.println("setNoBean2 : " + member2);
        }

        @Autowired
        public void setNoBean3(Optional<Member>  member3){
            System.out.println("setNoBean3 : " + member3);
            /*
            메서드를 호출하고, 빈값이면 Optional.empty 를 반환한다.
            NullPointException 발생을 없앨 수 있다.
             */
        }



    }
}
