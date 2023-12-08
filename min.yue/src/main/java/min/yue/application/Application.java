package min.yue.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "min.yue") 
@EnableJpaRepositories(basePackages = "min.yue.repository" , entityManagerFactoryRef = "entityManagerFactory")
@EntityScan("min.yue.data")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
