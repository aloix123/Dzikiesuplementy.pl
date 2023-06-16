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
	// - NAPRAW PRZYCISKI
	// - NAPISZ KOD KTÓ¶Y INCREMENTUJE I DECREMENTUJE ILOŚĆ PRODUKTU
	// - SPRAW ABY W KOSZYKU NIE BYŁO TYCH SAMYCH PRODUKTÓW
	// - SPRAW ABY DODANIE NOWEGO PRODUKTU DODAŁO ILOŚĆ +1 JEŚLI JEST W KOSZYKU TAKI PRODUKT

}
