package avaliando_restaurantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avaliando_restaurantes.domain.Avaliacao;
import avaliando_restaurantes.repository.AvaliacaoRepository;
import avaliando_restaurantes.services.exceptions.ObjectNotFoundException;

@Service
public class AvaliacaoService {
	@Autowired
	private AvaliacaoRepository repository;

	public List<Avaliacao> findAll() {
		return repository.findAll();
	}

	public Avaliacao findById(String id) {
		Optional<Avaliacao> avaliacao = repository.findById(id);
		return avaliacao.orElseThrow(()->new ObjectNotFoundException("Usuário nao encontrado!"));
	}
	public Avaliacao insert(Avaliacao avaliacao){
		return repository.save(avaliacao);
	}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
}