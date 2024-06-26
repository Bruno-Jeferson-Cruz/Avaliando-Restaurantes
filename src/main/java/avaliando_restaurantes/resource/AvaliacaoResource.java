package avaliando_restaurantes.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import avaliando_restaurantes.domain.Avaliacao;
import avaliando_restaurantes.domain.AvaliacaoDTO;
import avaliando_restaurantes.services.AvaliacaoService;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoResource {
	@Autowired
	private AvaliacaoService service;

	@GetMapping
	public ResponseEntity<List<AvaliacaoDTO>> findAll() {
		List<Avaliacao> list = service.findAll();
		List<AvaliacaoDTO> listDto= list.stream().map(x -> new AvaliacaoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<AvaliacaoDTO> findById(@PathVariable String id) {
		Avaliacao avaliacao = service.findById(id);
		return ResponseEntity.ok().body(new AvaliacaoDTO(avaliacao));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Avaliacao avaliacao) {
		avaliacao = service.insert(avaliacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
