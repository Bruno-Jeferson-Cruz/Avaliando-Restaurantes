package avaliando_restaurantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avaliando_restaurantes.domain.User;
import avaliando_restaurantes.domain.UserDTO;
import avaliando_restaurantes.repository.UserRepository;
import avaliando_restaurantes.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(()->new ObjectNotFoundException("Usuário nao encontrado!"));
	}
	public User insert(User user){
		return repository.save(user);
	}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	public User update(User newUser) {
		User user=findById(newUser.getId());
		updateData(user, newUser);
		return repository.save(user);
	}
	public User fromDto(UserDTO userDto,String senha) {
		return new User(userDto.getId(),userDto.getNome(),senha);
	}
	public void updateData(User user,User newUser) {
		user.setNome(newUser.getNome());
		user.setSenha(newUser.getSenha());
	}
}
