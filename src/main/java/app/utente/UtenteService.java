package app.utente;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import app.exceptions.BadRequestException;
import app.exceptions.NotFoundException;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;

	// Versione 1
//	public Utente create(Utente u) {
//		return utenteRepo.save(u);
//	}

	// Versione 2 con controllo
//	public Utente create2(Utente u) {
//		utenteRepo.findByEmail(u.getEmail()).ifPresent(utente -> {
//			throw new BadRequestException(
//					"ATTENZIONE!!! L'email con la quale stai cercando di registarti è già in uso da un altro utente");
//		});
//		return utenteRepo.save(u);
//	}

	// Versione 3 con controllo e payload
	public Utente create3(UtentePayload u) {
		utenteRepo.findByEmail(u.getEmail()).ifPresent(utente -> {
			throw new BadRequestException(
					"ATTENZIONE!!! L'email con la quale stai cercando di registarti è già in uso da un altro utente");
		});
		Utente newUtente = new Utente(u.getNome(), u.getCognome(), u.getEmail());
		return utenteRepo.save(newUtente);
	}

	// Versione 1
//	public List<Utente> find() {
//		return utenteRepo.findAll();
//	}

	// Versione 2 con paginazione
	public Page<Utente> find2(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return utenteRepo.findAll(pageable);
	}

	// Versione 1
	public Utente findById(UUID id) throws NotFoundException {
		return utenteRepo.findById(id).orElseThrow(() -> new NotFoundException("ATTENZIONE!!! Utente non trovato!"));
	}

	// Versione 1
	public Utente findByIdAndUpdate(UUID id, Utente u) throws NotFoundException {
		Utente found = this.findById(id);

		found.setUtenteId(id);
		found.setNome(u.getNome());
		found.setCognome(u.getCognome());
		found.setEmail(u.getEmail());

		return utenteRepo.save(found);
	}

	// Versione 1
	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Utente found = this.findById(id);
		utenteRepo.delete(found);
	}

}
