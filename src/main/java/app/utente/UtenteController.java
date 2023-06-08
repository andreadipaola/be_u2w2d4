package app.utente;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
	@Autowired
	private UtenteService utenteService;

	// Versione 1
//	@GetMapping("")
//	public List<Utente> getUtenti() {
//		return utenteService.find();
//	}

	// Versione 2 con paginazione
	@GetMapping("")
	public Page<Utente> getUsers2(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return utenteService.find2(page, size, sortBy);
	}

	// Versione 1
//	@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Utente saveUser(@RequestBody @Validated Utente body) {
//		return utenteService.create(body);
//	}

	// Versione 2 con payload
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser2(@RequestBody @Validated UtentePayload body) {
		return utenteService.create3(body);
	}

	// Versione 1
	@GetMapping("/{utenteId}")
	public Utente getUser(@PathVariable UUID utenteId) throws Exception {
		return utenteService.findById(utenteId);
	}

	// Versione 1
	@PutMapping("/{utenteId}")
	public Utente updateUser(@PathVariable UUID utenteId, @RequestBody Utente body) throws Exception {
		return utenteService.findByIdAndUpdate(utenteId, body);
	}

	// Versione 1
	@DeleteMapping("/{utenteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID utenteId) throws Exception {
		utenteService.findByIdAndDelete(utenteId);
	}

}
