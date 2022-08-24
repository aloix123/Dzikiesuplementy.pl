package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import project.sampledata.SampleProducts;
import project.util.ClientFIlehandler;
import project.util.Loginhandler;

import javax.annotation.PreDestroy;
import java.nio.file.Files;

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
	//stwórz koszyk działający
	//utwórz funkcję dodaj produkt
	//dodaj funkcję przy rejestracji dla ludzi , która sprawdza czy jest user z takimi samymi parametrami

}
