package app.utente;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utente {

	@Id
	@GeneratedValue
	@Column(name = "utente_id")
	private UUID utenteId;

	private String nome;
	private String cognome;
	private String email;

//	@OneToMany(mappedBy = "utente")
//	private Set<Prenotazione> prenotazioni;

	public Utente(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}

}
