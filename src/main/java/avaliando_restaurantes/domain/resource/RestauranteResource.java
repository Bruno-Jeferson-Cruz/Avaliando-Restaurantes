package avaliando_restaurantes.domain.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import avaliando_restaurantes.domain.Restaurante;
import avaliando_restaurantes.services.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteResource {
	@Autowired
	private RestauranteService service;

	@GetMapping
	public ResponseEntity<List<Restaurante>> findAll() {
		List<Restaurante> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Restaurante> findById(@PathVariable String id) {
		Restaurante restaurante = service.findById(id);
		return ResponseEntity.ok().body(restaurante);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Restaurante restaurante) {
		restaurante = service.insert(restaurante);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(restaurante.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
