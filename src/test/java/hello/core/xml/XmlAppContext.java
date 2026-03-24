package hello.core.xml;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext("AppConfig.xml");
        MemberService memberService = genericXmlApplicationContext.getBean("MemberService", MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }



}
