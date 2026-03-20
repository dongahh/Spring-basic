package hello.core.singleton;

public class SingletonService {

    //외부에서 SingletonService 객체를 호출할 수 없게 한다.
    private static final SingletonService instance = new SingletonService();

    //instance 을 호출할 수 있는 유일한 방법
    public static SingletonService getInstance(){
        return instance;
    }

    //외부에서 객체를 생성할 수 없도록 생성자를 private로 설계
    private SingletonService(){

    }

    public void logic (){
        System.out.println("싱글톤 객체 로직 호출");
    }



}
