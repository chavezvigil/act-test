package sv.com.telefonica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({ "sv.com.telefonica" })
@PropertySource("classpath:configuration.properties")
@SpringBootApplication
public class ActApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActApplication.class, args);
	}

}
