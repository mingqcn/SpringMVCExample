package spittr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author mingqiu
 *
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan(basePackages={"spittr.service","spittr.view"})
public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}	
}
