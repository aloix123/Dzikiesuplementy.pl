package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.util.ClientFIlehandler;
import project.util.Loginhandler;

import javax.annotation.PreDestroy;

@SpringBootApplication()

public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}
	@PreDestroy
	public void destroyUserInfo() {

		Loginhandler loginhandler=new Loginhandler();
		loginhandler.clearfile();
		System.out.println(" user informations Destroyed");
	}
	@PreDestroy
	public void destroyClientinfo() {
		ClientFIlehandler clientFIlehandler=new ClientFIlehandler();
		clientFIlehandler.clearfile();
		System.out.println(" also client informations Destroyed");
	}
	//TODO

	//FIXME NAPRAW KOSZYK:
	//  - jak będziesz miał czas to zmień te grafiki bo są brzyskie
	// - po zakupie produktów dodaj informacje zwrątną (nwm jakiś alert czy coś)
	// - napraw wygląd paska głównego
	// - dodaj jakąś treść na głównej stronie

}
