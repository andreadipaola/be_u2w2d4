package app.utente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UtentePayload {
	@NotNull(message = "Il nome è obbligatorio")
	@Size(min = 3, max = 30, message = "Nome min 3 caratteri, massimo 30")
	String nome;
	@NotNull(message = "Il cognome è obbligatorio")
	String cognome;
	@Email(message = "Non hai inserito un indirizzo email valido")
	String email;
	String password;
}
