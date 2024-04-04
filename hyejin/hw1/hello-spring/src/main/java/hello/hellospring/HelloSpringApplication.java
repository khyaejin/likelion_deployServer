package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) { //run 후 http://localhost:8080/HelloJSP2/hello2.jsp으로 웹 페이지 접근
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	public static class SpringConfig {
	}
}

/**
 빌드하고 실행하는 법
 콘솔로 이동
 ./gradlew build
 cd build/libs
 java -jar hello-spring-0.0.1-SNAPSHOT.jar
 실행 확인
 **/