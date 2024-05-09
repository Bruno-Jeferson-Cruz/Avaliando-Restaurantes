package avaliando_restaurantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avaliando_restaurantes.domain.Restaurante;
import avaliando_restaurantes.repository.RestauranteRepository;
import avaliando_restaurantes.services.exceptions.ObjectNotFoundException;

@Service
public class RestauranteService {
	@Autowired
	private RestauranteRepository repository;

	public List<Restaurante> findAll() {
		return repository.findAll();
	}

	public Restaurante findById(String id) {
		Optional<Restaurante> restaurante = repository.findById(id);
		return restaurante.orElseThrow(()->new ObjectNotFoundException("Usuário nao encontrado!"));
	}
	public Restaurante insert(Restaurante restaurante){
		return repository.save(restaurante);
	}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
}