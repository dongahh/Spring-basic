package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	//스프링부트는 웹 라이브러리가 없으면 AnnotationConfigApplicationContext
	// 웹 라이브러리가 있으면 AnnotationConfigServletWebServerApplicationContext
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
