package avaliando_restaurantes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import avaliando_restaurantes.domain.User;
import avaliando_restaurantes.repository.UserRepository;

@Configuration
public class Instantiattion implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... arg0) throws Exception {
		userRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "1234");
		User alex = new User(null, "Alex Green", "1234");
		User bob = new User(null, "Bob Grey", "1234");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
	
	}

}
