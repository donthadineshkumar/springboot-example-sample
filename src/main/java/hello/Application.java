package hello;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 * @SpringBootApplication adds following:
 * 
 * @Configuration -tags as a source of bean definitions for the application context
 * 
 * @EnableAutoConfiguration - tells Spring Boot to start adding beans based on 
 * classpath settings and other beans.For instance, normally you would add @EnableWebMvc
 * for a spring MVC app, but spring boot adds this when it sees spring-webmvc on classpath
 * 
 * This tells that it is a web app and activates the DispatcherServlet
 * 
 * @ComponentScan - looks for other components, configurations, and services in the hello
 * package
 * 
 */

@SpringBootApplication
public class Application {
	
	public static void main(String[] args){
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		System.out.println("Lets print the beans providedd by spring boot");
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		
		
	}

}
