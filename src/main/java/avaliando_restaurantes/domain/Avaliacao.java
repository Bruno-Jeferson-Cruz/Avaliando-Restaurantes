package avaliando_restaurantes.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Avaliacao implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Double nota;
	private String desc;
	private UserDTO autor;
	private Restaurante restaurante;
	
	public Avaliacao() {
		super();
	}
	public Avaliacao(String id, Double nota, String desc, UserDTO autor) {
		super();
		this.id = id;
		this.nota = nota;
		this.desc = desc;
		this.autor = autor;

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public UserDTO getAutor() {
		return autor;
	}
	public void setAutor(UserDTO autor) {
		this.autor = autor;
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
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
		Avaliacao other = (Avaliacao) obj;
		return Objects.equals(id, other.id);
	}
}
