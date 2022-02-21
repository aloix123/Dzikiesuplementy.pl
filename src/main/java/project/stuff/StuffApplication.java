package project.stuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class StuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuffApplication.class, args);
	}

}
