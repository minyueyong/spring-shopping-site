package min.yue.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "asia.fortitude") 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
