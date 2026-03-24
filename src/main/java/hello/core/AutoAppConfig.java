package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //기본 패키지 지정. 안 적을 경우 @ComponentScan 이 붙은 설정 정보 클래스의 패키지부터 시작됨.
        //그래서 프로젝트의 최상단에 두면 된다.
        basePackages =  "hello.core",// 두개 적을 수 있음{ "hello.service"},

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        /*
        ComponentScan을 사용하면 @Configuration 에 모든 클래스 및 메서드가 등록이 되면서,
        AppConfig.class 도 자동으로 빈에 등록이 된다. 그래서 Configration.class 를 제외시켜준다.

        대신 사용하려는 구현체에 @Autowire 을 붙여줘야한다.
         */
)
public class AutoAppConfig {

    //class 내에 있는 모든 메서드를 @Bean 으로 입력해서 빈에 입력시키지 않고
    //한 번에 처리


}
