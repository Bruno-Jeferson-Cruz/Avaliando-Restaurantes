package avaliando_restaurantes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import avaliando_restaurantes.domain.Restaurante;

@Repository
public interface RestauranteRepository extends MongoRepository<Restaurante, String>{
	
}
