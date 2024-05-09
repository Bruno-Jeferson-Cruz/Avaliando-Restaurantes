package avaliando_restaurantes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import avaliando_restaurantes.domain.Avaliacao;
import avaliando_restaurantes.domain.Restaurante;
import avaliando_restaurantes.domain.User;
import avaliando_restaurantes.domain.UserDTO;
import avaliando_restaurantes.repository.AvaliacaoRepository;
import avaliando_restaurantes.repository.RestauranteRepository;
import avaliando_restaurantes.repository.UserRepository;

@Configuration
public class Instantiattion implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired 
	private RestauranteRepository restauranteRepository;

	@Override
	public void run(String... arg0) throws Exception {
		userRepository.deleteAll();
		avaliacaoRepository.deleteAll();
		restauranteRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "1234");
		User alex = new User(null, "Alex Green", "1234");
		User bob = new User(null, "Bob Grey", "1234");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Restaurante r1=new Restaurante(null, "Siri Cascudo");
		Restaurante r2=new Restaurante(null, "Gusteau's");
		Restaurante r3=new Restaurante(null, "Pizza Planet");
		
		restauranteRepository.saveAll(Arrays.asList(r1,r2,r3));
		
		Avaliacao av1=new Avaliacao(null, 8, "Atrasou,mas estava bom!", new UserDTO(maria),r2);
		Avaliacao av2=new Avaliacao(null, 10, "Tudo excelente!", new UserDTO(bob),r3);
		Avaliacao av3=new Avaliacao(null, 4, "Atrasou e a comida estava fria!", new UserDTO(alex),r1);
		Avaliacao av4=new Avaliacao(null, 8, "A comida estava boa,mas veio sem batata!", new UserDTO(maria),r2);
		
		
		avaliacaoRepository.saveAll(Arrays.asList(av1,av2,av3,av4));
		
		restauranteRepository.deleteAll();
		
		r1=new Restaurante(null, "Siri Cascudo", Arrays.asList(av3));
		r2=new Restaurante(null, "Gusteau's", Arrays.asList(av1,av4));
		r3=new Restaurante(null, "Pizza Planet", Arrays.asList(av2));
		
		restauranteRepository.saveAll(Arrays.asList(r1,r2,r3));
	
	}

}
