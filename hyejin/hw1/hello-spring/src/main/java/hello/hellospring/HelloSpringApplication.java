package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) { //run 후 http://localhost:8080/HelloJSP2/hello2.jsp으로 웹 페이지 접근
		SpringApplication.run(HelloSpringApplication.class, args);
		}

}
