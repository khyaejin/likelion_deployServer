package spring.springcorebasic.beanfind;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.springcorebasic.AppConfig;

public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBean(){
		Arrays.stream(ac.getBeanDefinitionNames()).forEach(beanDefinitionName -> {
			System.out.println("name = " + beanDefinitionName + " object = " + ac.getBean(beanDefinitionName));
		});
	}

	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	void findApplicationBean(){
		Arrays.stream(ac.getBeanDefinitionNames()).forEach(beanDefinitionName -> {
			if(ac.getBeanDefinition(beanDefinitionName).getRole() == BeanDefinition.ROLE_APPLICATION){
				System.out.println("name = " + beanDefinitionName + " object = " + ac.getBean(beanDefinitionName));
			}
		});
	}
}
