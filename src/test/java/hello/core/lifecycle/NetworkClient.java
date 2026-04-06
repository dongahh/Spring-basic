package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;

public class NetworkClient {

    // 빈의 생명주기 콜백은
    // 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 소멸전 콜백 -> 스프링 종료
    //초기화 콜백 : 빈이 생성되고, 빈의 의존관계 주입이 완료된 후 호출
    //소멸전 콜백 : 빈이 소멸되기 직전에 호출
    private String url;


    public NetworkClient(){
        System.out.println("생성자 호출, url : " + url);
        //connect();
        //call("초기화 연결 메시지");

    }

    //서비스 시작 시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }
    //
    public void call(String message){
        System.out.println("call : " + url + " message : " + message);
    }
    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("disconnect : " + url);
    }

    //url 셋팅
    public void setUrl(String url) {
        this.url = url;
    }

    /*
    1. @Bean 에 initMethod, destroyMethod
     초기화, 소멸 메서드 는 Bean 에 등록 시켜줘야함. 외부 라이브러리에서 사용 가능
    2. @PostConstruct , @ preDestroy 에노테이션 사용
     @PostConstruct , @ preDestroy 사용하면 config 에서 수정할 필요없음.
     이 방법이 가장 권장되지만, 외부 라이브러리에서 사용 불가능
    */
    //초기값 셋팅
    @PostConstruct
    public void init(){

        System.out.println("NetworkCline.init");
        connect();
        call("초기화 연결 메시지");
    }

    //소멸할때 진행되는 함수 셋팅
    @PostConstruct
    public void close(){
        System.out.println("NetworkClinet.close");
        disconnect();

    }


}
