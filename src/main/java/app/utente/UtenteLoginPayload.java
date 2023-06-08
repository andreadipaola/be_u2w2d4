package app.utente;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class UtenteLoginPayload {
	@Email(message = "Non hai inserito un indirizzo email valido")
	String email;
	String password;
}
