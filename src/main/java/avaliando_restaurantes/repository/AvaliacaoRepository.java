package avaliando_restaurantes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import avaliando_restaurantes.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String>{
	
}
