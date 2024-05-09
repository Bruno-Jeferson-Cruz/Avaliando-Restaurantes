package avaliando_restaurantes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import avaliando_restaurantes.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
