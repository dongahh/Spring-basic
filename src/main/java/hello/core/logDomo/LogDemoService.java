package hello.core.logDomo;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    // private final ObjectProvider<MyLogger> myLoggerProvider; //Provider 사용
    private final MyLogger myLogger;
    public void logic(String id){
        //MyLogger myLogger = myLoggerProvider.getObject(); //Provider 사용
        myLogger.log("Service id : " + id);
    }
}

/*
서버 시작 (Spring Boot Run): 스프링 컨테이너가 @Service가 붙은 클래스를 보고 싱글톤 객체를 미리 딱 하나 만듭니다.

의존성 주입 시도: 서비스를 만들면서 "어? 얘(Service)가 리퀘스트 스코프 빈을 달라고 하네?" 하고 주입을 시도합니다.

대참사 발생: 하지만 지금은 서버만 켰을 뿐, 실제 HTTP 요청(Request)이 들어오지 않았습니다. 즉, 리퀘스트 빈은 아직 세상에 존재하지 않습니다.

에러 출력: 스프링은 "넣어줄 대상이 없는데 어떻게 서비스를 만드냐!
 */