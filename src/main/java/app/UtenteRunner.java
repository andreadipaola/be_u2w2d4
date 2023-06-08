package app;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import app.utente.Utente;
import app.utente.UtenteService;

@Component
@Order(1)
public class UtenteRunner implements ApplicationRunner {
	@Autowired
	UtenteService utenteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		for (int i = 0; i < 10; i++) {
			try {

				String nome = faker.name().firstName();
				String cognome = faker.name().lastName();
				String email = faker.internet().emailAddress();
				String password = faker.internet().password();
				Utente utente = new Utente(nome, cognome, email, password);
				// Ho usato la privma versione del metodo create per popolare il DB
//				utenteService.create(utente);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
