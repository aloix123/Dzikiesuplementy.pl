package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication(scanBasePackages = {"project"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//TODO
	//Po zalogowaniu spraw aby główne menu było inne oraz przystosowane tylko dla urzytkownika (witaj user)
	//dodaj okienko personalnych danych
	//zrób wkońcu normalną listę produktów
	//utwórz funkcję dodaj produkt
	//dodaj funkcję przy rejestracji dla ludzi , która sprawdza czy jest user z takimi samymi parametrami

}
