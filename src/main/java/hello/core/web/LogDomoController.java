package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.logDomo.LogDemoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.http.HttpRequest;

@Controller
@RequiredArgsConstructor  // 생성자가 하나인경우 자동으로 생성자 등록
public class LogDomoController {

    //private final ObjectProvider<MyLogger> myLoggerProvider;//Provider 사용
    //mylogger를 찾을 수 있는 디펜던시가 주입이 됨.

    private final MyLogger myLogger;
    private final LogDemoService logDemoService;


    @RequestMapping("log-demo")
    @ResponseBody
    public String logDomo(HttpServletRequest request){

        String requestURL = request.getRequestURL().toString();

        //MyLogger myLogger = myLoggerProvider.getObject();//Provider 사용.
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");

        /*
        서버가 켜질때 미리 만들어지는 객체(singleton)가
        사용자가 접속할대만 생겨나는 개체(request scope)를 그냥 가지고 있으려고 하면
        문제발생.

         */

        logDemoService.logic("testId");
        return "OK";
    }

}
