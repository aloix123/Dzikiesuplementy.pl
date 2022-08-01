package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import project.util.Loginhandler;

import javax.annotation.PreDestroy;
import java.nio.file.Files;

@SpringBootApplication()
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@PreDestroy
	public void destroy() {
		Loginhandler.clearfile();
		System.out.println("Destroyed");
	}
	//TODO
	//dodaj okienko personalnych danych
	//zrób wkońcu normalną listę produktów
	//utwórz funkcję dodaj produkt
	//dodaj funkcję przy rejestracji dla ludzi , która sprawdza czy jest user z takimi samymi parametrami

}
