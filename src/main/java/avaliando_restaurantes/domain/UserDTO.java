package avaliando_restaurantes.domain;

import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	public UserDTO() {
		super();
	}
	public UserDTO(User user) {
		this.id=user.getId();
		this.nome=user.getNome();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
